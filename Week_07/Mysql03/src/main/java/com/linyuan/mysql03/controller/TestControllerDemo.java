package com.linyuan.mysql03.controller;

import com.linyuan.mysql03.bean.Orders;
import com.linyuan.mysql03.service.OrderDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author DengXi
 * @Date 2021/3/7 11:13 下午
 * @desc:描述
 */
@RestController
public class TestControllerDemo {
    @Resource(name = "orderDemoService")
    private OrderDemoService ordersService2;

    @GetMapping("/test1")
    public String test1() {
        ordersService2.insert();
        return "success";
    }


    @GetMapping("/test2")
    public String test2() {
        ordersService2.insertByThreadPool();
        return "success";
    }

    @GetMapping("/getAll")
    public List<Orders> getAll() {
        return ordersService2.getAll();
    }
}
