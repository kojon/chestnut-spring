package cn.net.chestnut.ribbonconsumer.service;

import cn.net.chestnut.ribbonconsumer.dto.User;
import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 缓存生效条件 在不同context中的缓存是不共享的，共享request内部一个ThreadLocal，所以request只能限于当前线程。
 * 执行优先级 构造函数 getCacheKey run getFallback
 *
 * @Description
 * @Author tarzan
 * @Date 2019/3/22 5:27 PM
 **/
public class UserGetCommand extends HystrixCommand<User> {

    private static final Logger logger = LoggerFactory.getLogger(UserGetCommand.class);

    private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("userCommandKey");

    private RestTemplate restTemplate;

    //缓存的key
    private Integer id;

    public UserGetCommand(RestTemplate restTemplate, Integer id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("userCacheCommand")).andCommandKey(GETTER_KEY)
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                                                                          .withRequestCacheEnabled(true)
                                                                          .withExecutionTimeoutInMilliseconds(5000)
                                                                          .withExecutionTimeoutEnabled(false)
                    ));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() {
        logger.info("thread:" + Thread.currentThread().getName());
        return restTemplate.getForObject("http://HELLO-SERVICE/users/{id}", User.class, id);
    }

    @Override
    public String getCacheKey() {
        return String.valueOf(id);
    }

    @Override
    protected User getFallback() {
        System.out.println("fallback" + id);
        User user = new User();
        user.setId(-1);
        user.setName("查询失败");
        return user;
    }

    public static void flushCache(Integer id){
        HystrixRequestCache.getInstance(GETTER_KEY, HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(id));
    }
}
