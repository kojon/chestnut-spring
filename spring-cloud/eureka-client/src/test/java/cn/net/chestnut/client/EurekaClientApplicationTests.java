package cn.net.chestnut.client;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)//引入spring对junit4的支持
@SpringApplicationConfiguration(classes = HelloController.class)//指定启动类
@WebAppConfiguration//开启web应用的配置，用于模拟ServletContent
public class EurekaClientApplicationTests {

    private MockMvc mvc;//用于模拟调用controller的接口发起请求

    @Before
    public void setUp() {
        //初始化对hellocontroller的模拟
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void hello() throws Exception {
        //perform函数执行一次请求调用
        mvc.perform(MockMvcRequestBuilders.get("/hello")
                                          .accept(MediaType.ALL))//用于接收数据类型
           .andExpect(status().isOk())//用于判断请求影响是否成功
           .andExpect(content().string(equalTo("Hello World")));//用于判断接口返回期望值
    }

}

