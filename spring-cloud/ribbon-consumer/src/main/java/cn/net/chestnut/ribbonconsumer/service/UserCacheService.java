package cn.net.chestnut.ribbonconsumer.service;

import cn.net.chestnut.ribbonconsumer.dto.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.sun.media.jfxmedia.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author tarzan
 * @Date 2019/3/25 3:08 PM
 **/
@Service
public class UserCacheService {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserCacheService.class);
    @Autowired
    RestTemplate restTemplate;

    public User userCacheCommand(Integer id) {
        //爬坑：这里一定是execute()，不能写成run() 因为只有这样才会先运行getCacheKey()来记录
        return new UserGetCommand(restTemplate,id).execute();
    }

    @CacheResult
    @HystrixCommand(fallbackMethod = "queryUserBackMethod", commandKey = "userCache", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
        @HystrixProperty(name = "requestCache.enabled", value = "true")})
    public User userCache(Integer id) {
        return restTemplate.getForObject("http://HELLO-SERVICE/users/{id}", User.class, id);
    }

    /**
     * 回退函数必须和他正常调用函数必须具有相同的
     */
    public User queryUserBackMethod(Integer id, Throwable e) {
        User user = new User();
        user.setId(-1);
        user.setName("查询失败");
        logger.error("异常：",e);
        return user;
    }


    public User userUpdateCommand(User user) {
        return new UserUpdateCommand(restTemplate,user).execute();
    }


}
