package com.itheima.controller;

import com.itheima.service.UserService;
import com.itheima.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private int port;

    /***
     * 根据id查询用户详情
     */
    @GetMapping(value = "/{id}")
    public User one(@PathVariable(value = "id") Long id){
        System.out.println("用户端口 "+port);
        return userService.findById(id);
    }
}
