package cn.net.chestnut.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SampleService {

    @Transactional
    public void uncheckedException(Runnable runnable) {
        runnable.run();
        throw new RuntimeException();
    }

    @Transactional
    public void checkedException(Runnable runnable) throws Exception {
        runnable.run();
        throw new Exception();
    }

    @Transactional(readOnly = true)
    public void readonly(Runnable runnable) {
        runnable.run();
    }

}
