package com.linyuan.mysql03.dao;

import com.linyuan.mysql03.bean.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author DengXi
 * @Date 2021/3/8 10:33 上午
 * @desc:描述
 */
@Mapper
public interface OrdersDao {
    @Insert("insert into orders(user_id, amount, status, create_time) values(#{userId}, #{amount}, #{status}, #{createTime})")
    int insert(Orders orders);

    @Insert("insert into orders(id, user_id, amount, status, create_time) values(#{id}, #{userId}, #{amount}, #{status}, #{createTime})")
    int insertV2(Orders orders);

    @Select("select * from orders")
    List<Orders> findAll();
}
