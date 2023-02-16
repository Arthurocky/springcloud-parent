package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.order.pojo.OrderInfo;
import com.itheima.service.OrderService;
import com.itheima.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    /**
     * 根据ID查询订单信息
     */
    @Override
    public OrderInfo findById(Long id) {
        //1.查询订单
        OrderInfo orderInfo = orderDao.selectById(id);
        //2.根据订单查询用户信息->需要调用  【item-user】  服务
        
        //3.封装user到订单中
        
        //4.返回订单信息
        return orderInfo;
    }
}