package com.itheima.controller;

import com.itheima.order.pojo.OrderInfo;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${server.port}")
    private int port;

    /**
     * 查询订单信息
     */
    @GetMapping(value = "/{id}")
    public OrderInfo one(@PathVariable(value = "id") Long id)
    {
        System.out.println("订单端口 "+port);
        return orderService.findById(id);
    }
}

