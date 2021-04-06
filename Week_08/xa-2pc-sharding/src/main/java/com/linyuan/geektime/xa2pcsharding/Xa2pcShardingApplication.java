package com.linyuan.geektime.xa2pcsharding;

import com.linyuan.geektime.xa2pcsharding.configuration.TransactionConfig;
import com.linyuan.geektime.xa2pcsharding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @Author DengXi
 * @Date 2021/3/8 10:33 上午
 * @desc:描述
 */
@SpringBootApplication
@Import(TransactionConfig.class)
public class Xa2pcShardingApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(Xa2pcShardingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderService.insert();
        orderService.insertFailed();
    }
}
