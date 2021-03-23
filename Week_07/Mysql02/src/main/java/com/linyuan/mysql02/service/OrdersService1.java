package com.linyuan.mysql.service;

import com.linyuan.mysql.annotation.DataSource2;
import com.linyuan.mysql.bean.Orders;
import com.linyuan.mysql.mapper.OrdersMapper1;
import com.linyuan.mysql.utils.SnowflakeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author DengXi
 * @Date 2021/3/7 11:09 下午
 * @desc:描述
 */
@Service("ordersService1")
public class OrdersService1 {
    @Autowired
    private OrdersMapper1 ordersMapper;

    @DataSource2
    public int insert() {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++) {
            Orders orders = new Orders();
            Random random = new Random(10);
            int j = random.nextInt();
            orders.setAmount(BigDecimal.valueOf(i * j * 10.0));
            orders.setCreateTime(LocalDateTime.now());
            orders.setStatus(i%2==0 ? 1 : 0);
            orders.setUserId((long) i * 1000);
            ordersMapper.insert(orders);
        }
        System.out.println("当前时间为: " + String.valueOf(System.currentTimeMillis() - startTime));
        return 1;
    }

    private static volatile Long time = 0L;

    @DataSource2
    public int insertByThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000));
        SnowflakeId snowflakeId = new SnowflakeId(1, 31);
        for (int i = 1; i <= 10; i++) {
            threadPoolExecutor.execute(() -> {
                long startTime1 = System.currentTimeMillis();
                for (int i1 = 1; i1 <= 10; i1++) {
                    Orders orders = new Orders();
                    Random random = new Random(10);
                    int j = random.nextInt();
                    orders.setId(snowflakeId.nextId());
                    orders.setAmount(BigDecimal.valueOf(i1 * j * 10.0));
                    orders.setCreateTime(LocalDateTime.now());
                    orders.setStatus(i1%2==0 ? 1 : 0);
                    orders.setUserId((long) i1 * 1000);
                    ordersMapper.insertV2(orders);
                }
                time += System.currentTimeMillis() - startTime1;
                System.out.println(time);
            });
        }
        return 1;
    }

    public List<Orders> findAll() {
        return ordersMapper.findAll();
    }
}
