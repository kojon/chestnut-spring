package cn.net.chestnut.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author tarzan
 * @Date 2019/3/25 6:08 PM
 **/
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/user/info")
    public User getUserInfo(Integer id) {
        logger.info("/user/info");
        return UserData.getUserMap().get(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String setUser(@RequestBody User user) {
        logger.info("/user");
        UserData.setUser(user);
        return "success";
    }

    @RequestMapping(value = "/users/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        logger.info("/users/{id}");
        return UserData.getUserMap().get(id);
    }
}
