package cn.net.chestnut.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author tarzan
 * @Date 2019/1/7 4:44 PM
 **/
@RestController
@RequestMapping
public class CustomizeController {

    private final Logger logger = LoggerFactory.getLogger(CustomizeController.class);

    @Value("${this.name}")
    private String name;

    @Value("#{'kojon'}")
    private String author;

    @Value("${this.message}")
    private String message;

    @RequestMapping(value = "/value")
    public String index() {
        return "name:"+name+", author:"+author+", message:"+message;
    }

}
