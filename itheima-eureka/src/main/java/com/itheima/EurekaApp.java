package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka注册中心 第二步：创建启动类 并加上开启EurekaServer注解
 * @author Arthurocky
 */
@SpringBootApplication
@EnableEurekaServer  //开启EurekaServer服务
public class EurekaApp {
    public static void main(String[] args)
    {
        SpringApplication.run(EurekaApp.class,args);
    }
}
