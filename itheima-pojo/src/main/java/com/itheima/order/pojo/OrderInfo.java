package com.itheima.order.pojo;

import com.itheima.user.pojo.User;
import lombok.Data;

import java.util.Date;

@Data
public class OrderInfo {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;
}
