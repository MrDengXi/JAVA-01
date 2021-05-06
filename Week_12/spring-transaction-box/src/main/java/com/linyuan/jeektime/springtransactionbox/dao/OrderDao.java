package com.linyuan.jeektime.springtransactionbox.dao;

import com.linyuan.jeektime.springtransactionbox.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author linyuan
 * @desc:描述
 */
@Mapper
public interface OrderDao {

    List<OrderEntity> findAll();

    void save(@Param("orderEntity") OrderEntity orderEntity);

    void updateStatus(@Param("orderEntity") OrderEntity orderEntity);

    void delete(@Param("id") Long id);

    void batchUpdateStatus(@Param("orderEntities") List<OrderEntity> orderEntities);
}
