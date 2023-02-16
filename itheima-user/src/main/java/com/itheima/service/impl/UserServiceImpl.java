package com.itheima.service.impl;
import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import com.itheima.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 根据id查询用户详情
     * @return
     */
    @Override
    public User findById(Long id) {
        return userDao.selectById(id);
    }

}
