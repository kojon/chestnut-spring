package cn.net.chestnut.ribbonconsumer.controller;

import cn.net.chestnut.ribbonconsumer.dto.User;
import cn.net.chestnut.ribbonconsumer.service.UserCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author tarzan
 * @Date 2019/1/7 7:23 PM
 **/
@RestController
public class CacheController {
    private static final Logger logger = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserCacheService userCacheService;

    /**
     * 基于注解的cache使用
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/users/cache/{id}")
    public User getUser(@PathVariable("id") Integer id) throws Exception{
        User user1=userCacheService.userCache(id);
        User user2=userCacheService.userCache(id);
        System.out.println(user1==user2);
        return user1;
    }

    /**
     * 自定义HystrixCommand实现缓存
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/users/cache2/{id}")
    public User getUser2(@PathVariable("id") Integer id) throws Exception{
        User user1=userCacheService.userCacheCommand(id);
        User user2=userCacheService.userCacheCommand(id);
        logger.info(user1==user2?"缓存成功":"缓存失败");
        return user1;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User putUser(User user) {
        return userCacheService.userUpdateCommand(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User putUser(Integer id,String name) {
        User user=userCacheService.userCacheCommand(id);
        String beforeName=user.getName();
        logger.info("修改前"+user.toString());
        user.setName(name);
        User user1= userCacheService.userUpdateCommand(user);
        if (user1.getId()!=-1) {
            User user2=userCacheService.userCacheCommand(id);
            logger.info("修改后"+user2.toString());
            logger.info("缓存清空验证"+((beforeName.equals(user2.getName()))?"失败":"成功"));
        }
        return user1;
    }
}
