package com.itheima.controller;

import com.itheima.order.pojo.OrderInfo;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询订单信息
     */
    @GetMapping(value = "/{id}")
    public OrderInfo one(@PathVariable(value = "id") Long id){
        return orderService.findById(id);
    }
}

