package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class,args);
    }


    /**
     * 微服务远程调用
     * 第一步：注册RestTemplate对象
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
