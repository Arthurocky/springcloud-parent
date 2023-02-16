package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced//开启负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //设置负载均衡策略：不常用
    //在配置文件中设置ribbon
    /*
    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }*/
}
