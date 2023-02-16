package com.itheima.controller;

import com.itheima.service.UserService;
import com.itheima.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /***
     * 根据id查询用户详情
     */
    @GetMapping(value = "/{id}")
    public User one(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }
}
