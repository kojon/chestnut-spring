package cn.net.chestnut;

import cn.net.chestnut.transaction.SampleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.ResultSet;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.springframework.transaction.TransactionDefinition.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@EnableTransactionManagement
public class TransactionTest {
    @Autowired
    private PlatformTransactionManager transactionManager;
    @Autowired
    private TransactionTemplate transaction;
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private SampleService sampleService;

    @Before
    public void cleanUp() {
        jdbc.execute("TRUNCATE TABLE sample.t");
    }

    /**
     * 测试插入数据
     * @param i
     * @return
     */
    private int insert(int i) {
        return jdbc.update("INSERT INTO sample.t VALUES (?)", i);
    }

    /**
     * 查询数据是否存在
     * @param value
     * @return
     */
    private boolean exists(int value) {
        return Objects.requireNonNull(
            jdbc.query("SELECT 1 FROM sample.t WHERE i = ?", ResultSet::next, value)
        );
    }

    /**
     * 获取不同类型的事务
     * @param propagationBehavior
     * @return
     */
    private TransactionTemplate transaction(int propagationBehavior) {
        TransactionTemplate template = new TransactionTemplate(transactionManager);
        template.setPropagationBehavior(propagationBehavior);
        return template;
    }

    /**
     * 测试事务回滚
     */
    @Test
    public void rollback() {
        try {
            transaction.execute(tx -> {
                insert(1);
                throw new RuntimeException();
            });
        } catch (RuntimeException e) {
            assertFalse(exists(1));
            return;
        }
        fail();
    }

    /**
     * 未知异常回滚
     */
    @Test(expected = UnexpectedRollbackException.class)
    public void unexpectedRollbackException() {
        transaction.execute(outer -> {
            insert(1);
            try {
                return transaction.execute(inner -> {
                    throw new RuntimeException();
                });
            } catch (RuntimeException ignored) {
                return 0;
            }
        });
    }

    /**
     * 事务内部异常
     */
    @Test
    public void handleInnerException() {
        transaction.execute(outer -> {
            insert(1);
            try {
                throw new RuntimeException();
            } catch (RuntimeException ignored) {
                return 0;
            }
        });
        assertTrue(exists(1));
    }

    /**
     * 外部事务回滚，内部事务也回滚
     */
    @Test
    public void required() {
        transaction(PROPAGATION_REQUIRED).execute(outer -> {
            assertTrue(outer.isNewTransaction());
            insert(1);
            transaction(PROPAGATION_REQUIRED).execute(inner -> {
                assertFalse(inner.isNewTransaction());
                return insert(2);
            });
            outer.setRollbackOnly();
            return null;
        });
        assertFalse(exists(1));
        assertFalse(exists(2));
    }

    /**
     * propagation_supports在事务中才会回滚
     */
    @Test
    public void supports() {
        transaction(PROPAGATION_SUPPORTS).execute(outer -> {
            assertFalse(outer.isNewTransaction());
            insert(1);
            outer.setRollbackOnly();
            return null;
        });
        assertTrue(exists(1));

        cleanUp();

        transaction(PROPAGATION_REQUIRED).execute(outer -> {
            assertTrue(outer.isNewTransaction());
            insert(1);
            transaction(PROPAGATION_SUPPORTS).execute(inner -> {
                assertFalse(inner.isNewTransaction());
                return insert(2);
            });
            outer.setRollbackOnly();
            return null;
        });
        assertFalse(exists(1));
        assertFalse(exists(2));
    }

    /**
     * PROPAGATION_MANDATORY必须在事务中，否则抛出异常
     */
    @Test(expected = IllegalTransactionStateException.class)
    public void mandatory() {
        transaction(PROPAGATION_MANDATORY).execute(outer -> insert(1));
    }

    /**
     * propagation_requires_new被其他事务包裹的时候，事务不回滚
     */
    @Test
    public void requiresNew() {
        transaction(PROPAGATION_REQUIRED).execute(outer -> {
            assertTrue(outer.isNewTransaction());
            insert(1);
            transaction(PROPAGATION_REQUIRES_NEW).execute(inner -> {
                assertTrue(inner.isNewTransaction());
                return insert(2);
            });
            outer.setRollbackOnly();
            return null;
        });
        assertFalse(exists(1));
        assertTrue(exists(2));

        transaction(PROPAGATION_REQUIRES_NEW).execute(inner -> {
            assertTrue(inner.isNewTransaction());
            insert(3);
            inner.setRollbackOnly();
            return null;
        });
        assertFalse(exists(3));
    }

    /**
     *propagation_not_supported事务内的方法不进行事务
     */
    @Test
    public void notSupported() {
        transaction(PROPAGATION_REQUIRED).execute(outer -> {
            assertTrue(outer.isNewTransaction());
            insert(1);
            transaction(PROPAGATION_NOT_SUPPORTED).execute(inner -> {
                assertFalse(inner.isNewTransaction());
                insert(2);
                inner.setRollbackOnly();
                return null;
            });
            outer.setRollbackOnly();
            return null;
        });
        assertFalse(exists(1));
        assertTrue(exists(2));

        transaction(PROPAGATION_NOT_SUPPORTED).execute(inner -> {
            assertFalse(inner.isNewTransaction());
            insert(3);
            inner.setRollbackOnly();
            return null;
        });
        assertTrue(exists(3));
    }

    /**
     * propagation_never当前有事务运行抛出异常
     */
    @Test(expected = IllegalTransactionStateException.class)
    public void never() {
        transaction(PROPAGATION_REQUIRED).execute(outer -> {
            assertTrue(outer.isNewTransaction());
            insert(1);
            return transaction(PROPAGATION_NEVER).execute(inner -> insert(2));
        });
    }

    /**
     * propagation_nested嵌套时独立于当前事务提交或回滚，如果未设置事务属性则保持当前事务属性。不被嵌套时是REQUIRED事务
     */
    @Test
    public void nested() {
        transaction(PROPAGATION_REQUIRED).execute(outer -> {
            assertTrue(outer.isNewTransaction());
            insert(1);
            return transaction(PROPAGATION_NESTED).execute(inner -> {
                assertFalse(inner.isNewTransaction());
                assertTrue(inner.hasSavepoint());
                insert(2);
                inner.setRollbackOnly();
                return null;
            });
        });
        assertTrue(exists(1));
        assertFalse(exists(2));

        cleanUp();

        transaction(PROPAGATION_REQUIRED).execute(outer -> {
            assertTrue(outer.isNewTransaction());
            insert(1);
            transaction(PROPAGATION_NESTED).execute(inner -> {
                assertFalse(inner.isNewTransaction());
                assertTrue(inner.hasSavepoint());
                return insert(2);
            });
            outer.setRollbackOnly();
            return null;
        });
        assertFalse(exists(1));
        assertFalse(exists(2));
    }

    /**
     * 抛出异常事务不回滚
     */
    @Test
    public void checkedException() {
        try {
            sampleService.checkedException(() -> insert(1));
        } catch (Exception ignore) {
        }
        assertTrue(exists(1));
    }

    /**
     * 未抛出异常事务回滚
     */
    @Test
    public void uncheckedException() {
        try {
            sampleService.uncheckedException(() -> insert(1));
        } catch (Exception ignore) {
        }
        assertFalse(exists(1));
    }

    /**
     * 查询操作事务设置只读，防止出现脏读、幻读
     */
    @Test
    public void readonly() {
        Runnable runnable = () -> {
            jdbc.execute("SELECT count(1) from employees.employees WHERE emp_no < 10000");
            jdbc.execute("SELECT * from employees.employees WHERE emp_no < 10000");
        };

        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.setReadOnly(true);
        transactionTemplate.execute(tx -> {
            runnable.run();
            return null;
        });

        sampleService.readonly(runnable);
    }

}
