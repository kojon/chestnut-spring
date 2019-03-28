package cn.net.chestnut.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author tarzan
 * @Date 2019/3/22 3:18 PM
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

    public String helloFallback() {
        return "error";
    }

    @HystrixCommand(fallbackMethod = "userFallback")
//    @HystrixCommand(fallbackMethod = "userFallback",ignoreExceptions = {RuntimeException.class})
    public String testException(Integer id) {
        throw new RuntimeException("failed");
    }

    public String userFallback(Integer id, Throwable e) {
        if ("failed".equals(e.getMessage())) {
            return "RuntimeException";
        }
        return "error";
    }



}
