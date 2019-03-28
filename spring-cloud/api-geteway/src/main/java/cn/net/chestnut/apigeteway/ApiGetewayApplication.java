package cn.net.chestnut.apigeteway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ApiGetewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiGetewayApplication.class).web(true).run(args);
    }

}
