package com.itheima.dao;

import com.itheima.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from tb_user where id = #{id}")
    User selectById(Long id);
}
