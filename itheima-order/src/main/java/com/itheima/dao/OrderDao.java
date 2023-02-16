package com.itheima.dao;


import com.itheima.order.pojo.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderDao{
    @Select("select * from tb_order where id = #{id}")
    OrderInfo selectById(Long id);
}
