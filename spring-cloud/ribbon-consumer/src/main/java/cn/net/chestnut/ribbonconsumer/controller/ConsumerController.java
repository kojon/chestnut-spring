package cn.net.chestnut.ribbonconsumer.controller;

import cn.net.chestnut.ribbonconsumer.dto.User;
import cn.net.chestnut.ribbonconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author tarzan
 * @Date 2019/1/7 7:23 PM
 **/
@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloService helloSevice;

    @RequestMapping(value = "/ribbon-consumer")
    public String helloConsumer(){
        return helloSevice.helloService();
    }
    @RequestMapping(value = "/getUserId")
    public String userConsumer(Integer id){
        return helloSevice.testException(id);
    }

    /**
     * get案例
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/info")
    public String user(Integer id){
        return restTemplate.getForEntity("http://HELLO-SERVICE/user/info?id={1}",String.class,id).getBody();
    }

    /**
     * post案例
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/add")
    public String user(User user){
        ResponseEntity responseEntity = restTemplate.postForEntity
            ("http://HELLO-SERVICE/user", user, String.class);
        return responseEntity.getBody().toString();
    }


}
