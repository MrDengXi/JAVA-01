package com.linyuan.mysql;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linyuan.mysql.bean.Orders;
import com.linyuan.mysql.mapper.OrdersMapper;
import com.linyuan.mysql.utils.SnowflakeId;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    void addOrders() throws InterruptedException {
        SnowflakeId snowflakeId = new SnowflakeId(1, 31);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int j = 0; j < 10; j++) {
            new Thread(() -> {
                System.out.println("aa");
                for (int i = 0; i < 100; i++) {
                    Orders orders = new Orders();
                    orders.setAmount(BigDecimal.valueOf(i*100 - i*40));
                    orders.setStatus(i%2 == 0 ? 0 : 1);
                    orders.setUserId(snowflakeId.nextId());
                    ordersMapper.insert(orders);

                }
                countDownLatch.countDown();
            }).start();

        }
        countDownLatch.await();
    }

    @Test
    void addOneOrders() throws InterruptedException {
        SnowflakeId snowflakeId = new SnowflakeId(1, 31);
        Orders orders = new Orders();
        orders.setAmount(BigDecimal.valueOf(99.9));
        orders.setStatus(1);
        Long userId = snowflakeId.nextId();
        System.out.println(userId);
        orders.setUserId(userId);
        ordersMapper.insert(orders);
    }

    @Test
    void getOrders() {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1374309492866838537L);
        Orders orders = ordersMapper.selectOne(queryWrapper);
        System.out.println(orders);
    }

}
