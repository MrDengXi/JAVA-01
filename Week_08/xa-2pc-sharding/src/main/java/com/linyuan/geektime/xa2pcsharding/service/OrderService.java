package com.linyuan.geektime.xa2pcsharding.service;

import com.linyuan.geektime.xa2pcsharding.entity.Orders;
import com.linyuan.geektime.xa2pcsharding.mapper.OrdersMapper;
import com.linyuan.geektime.xa2pcsharding.utils.SnowflakeId;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * @Author DengXi
 * @Date 2021/3/8 10:33 上午
 * @desc:描述
 */
@Service
public class OrderService {

    @Autowired
    private OrdersMapper ordersMapper;

    private static final String charters = "abcdefghijklmnopqrstuvwxyz";

    @Transactional(rollbackOn = SQLException.class)
    @ShardingTransactionType(TransactionType.XA)
    public TransactionType insert(){
        SnowflakeId snowflakeId = new SnowflakeId(1, 31);
        Orders orders = new Orders();
        orders.setAmount(BigDecimal.valueOf(99.9));
        orders.setStatus(1);
        Long userId = snowflakeId.nextId();
        System.out.println(userId);
        orders.setUserId(userId);
        ordersMapper.insert(orders);
        return TransactionTypeHolder.get();
    }

    @Transactional(rollbackOn = SQLException.class)
    @ShardingTransactionType(TransactionType.XA)
    public void insertFailed() throws SQLException {
        SnowflakeId snowflakeId = new SnowflakeId(1, 31);
        Orders orders = new Orders();
        orders.setAmount(BigDecimal.valueOf(98.9));
        orders.setStatus(2);
        Long userId = snowflakeId.nextId();
        System.out.println(userId);
        orders.setUserId(userId);
        ordersMapper.insert(orders);
        throw new SQLException("insert error");
    }


}