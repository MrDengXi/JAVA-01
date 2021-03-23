package com.linyuan.mysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linyuan.mysql.bean.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @Author DengXi
 * @Date 2021/3/8 10:33 上午
 * @desc:描述
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
