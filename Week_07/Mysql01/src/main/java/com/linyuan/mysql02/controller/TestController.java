package com.linyuan.mysql02.controller;

import com.linyuan.mysql02.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author DengXi
 * @Date 2021/3/7 11:13 下午
 * @desc:描述
 */
@RestController
public class TestController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/test1")
    public String test1() {
        ordersService.insert();
        return "success";
    }


    @GetMapping("/test2")
    public String test2() {
        ordersService.insertByThreadPool();
        return "success";
    }
}
