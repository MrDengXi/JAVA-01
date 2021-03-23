package com.linyuan.mysql.controller;

import com.linyuan.mysql.service.OrdersService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author DengXi
 * @Date 2021/3/7 11:13 下午
 * @desc:描述
 */
@RestController("testController1")
public class TestController1 {
    @Resource(name = "ordersService1")
    private OrdersService1 ordersService1;

    @GetMapping("/test1")
    public String test1() {
        ordersService1.insert();
        return "success";
    }


    @GetMapping("/test2")
    public String test2() {
        ordersService1.insertByThreadPool();
        return "success";
    }
}
