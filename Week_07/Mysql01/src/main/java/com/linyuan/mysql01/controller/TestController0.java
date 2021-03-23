package com.linyuan.mysql01.controller;

import com.linyuan.mysql01.service.OrdersService0;
import com.linyuan.mysql01.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author DengXi
 * @Date 2021/3/7 11:13 下午
 * @desc:描述
 */
@RestController("testController0")
public class TestController0 {
    @Resource
    private OrdersService0 ordersService0;
    @Resource
    private PatientService patientService;

    @GetMapping("/test1")
    public String test1() {
        ordersService0.insert();
        return "success";
    }


    @GetMapping("/test2")
    public String test2() {
        patientService.insertByThreadPool();
        return "success";
    }
}
