package cn.net.chestnut.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author tarzan
 * @Date 2019/1/7 4:44 PM
 **/
@RestController
@RequestMapping
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello")
    public String index() {
        logger.info("hello service 被消费！");
        return "Hello World";
    }
}
