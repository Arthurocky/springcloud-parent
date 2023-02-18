package com.itheima.controller;

import com.itheima.config.Myconfig;
import com.itheima.order.pojo.OrderInfo;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//方式一：配置中心刷新配置
//@RefreshScope
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${person.name}")
    private String name;

    @Value("${server.port}")
    private int port;

    @Autowired
    private Myconfig myconfig;

    /**
     * 查询订单信息
     */
    @GetMapping(value = "/{id}")
    public OrderInfo one(@PathVariable(value = "id") Long id)
    {
        System.out.println("订单端口 "+port);
        return orderService.findById(id);
    }


    /**
     * 统一配置管理-测试 看是否能够获取到nacos中配置的值
     */
    @GetMapping
    public String xiaohong(){
        return name+"====="+myconfig.getName();
    }

}

