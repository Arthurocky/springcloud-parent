package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.order.pojo.OrderInfo;
import com.itheima.service.OrderService;
import com.itheima.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Resource
    private RestTemplate restTemplate;

    /**
     * 根据ID查询订单信息
     */
    @Override
    public OrderInfo findById(Long id)
    {
        //1.查询订单
        OrderInfo orderInfo = orderDao.selectById(id);
        //2.根据订单查询用户信息->需要调用  【item-user】  服务
        //微服务远程调用
        //第二步：模拟浏览器发送http请求到用户微服务，最终得到用户对象
        //参数1 url:被调用微服务的请求地址  参数2：user.class 返回对象类型
        //String url = "http://localhost:18081/user/"+orderInfo.getUserId();
        //User user = restTemplate.getForObject(url, User.class);

        String url = "http://itheima-user/user/" + orderInfo.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        //3.封装user到订单中
        orderInfo.setUser(user);
        //4.返回订单信息
        return orderInfo;
    }
}