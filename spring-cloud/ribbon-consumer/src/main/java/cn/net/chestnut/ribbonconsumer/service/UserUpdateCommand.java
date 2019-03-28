package cn.net.chestnut.ribbonconsumer.service;

import cn.net.chestnut.ribbonconsumer.dto.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 更新操作需要清除缓存
 *
 * 爬坑：UserUpdateCommand和UserGetCommand的泛型必须一致，因为他们使用了同一个缓存
 * @Description
 * @Author tarzan
 * @Date 2019/3/22 5:27 PM
 **/
public class UserUpdateCommand extends HystrixCommand<User> {

    private static final Logger logger = LoggerFactory.getLogger(UserUpdateCommand.class);

    private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("userUpdateCommandKey");

    private RestTemplate restTemplate;

    //缓存的key
    private User user;

    public UserUpdateCommand(RestTemplate restTemplate, User user) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("userCacheCommand")).andCommandKey(GETTER_KEY)
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withRequestCacheEnabled(false)
                        .withExecutionTimeoutInMilliseconds(5000)
//                                                                          .withExecutionTimeoutEnabled(false)
                    ));
        this.restTemplate = restTemplate;
        this.user = user;
    }

    @Override
    protected User run() {
        logger.info("thread:" + Thread.currentThread().getName());
        String status= restTemplate.postForObject("http://HELLO-SERVICE/user", user, String.class);
        if (status.equals("success")) {
            UserGetCommand.flushCache(user.getId());
            return user;
        }else{
            return errorUser();
        }
    }

    @Override
    public String getCacheKey() {
        return String.valueOf(user.getId());
    }

    @Override
    public User getFallback() {
        super.getFallback();
        return errorUser();
    }

    private User errorUser() {
        User user = new User();
        user.setId(-1);
        user.setName("查询失败");
        return user;
    }

}
