package com.itheima.service;


import com.itheima.order.pojo.OrderInfo;

public interface OrderService {

    /**
     * 根据ID查询订单信息
     * @param id
     * @return
     */
    OrderInfo findById(Long id);
}
