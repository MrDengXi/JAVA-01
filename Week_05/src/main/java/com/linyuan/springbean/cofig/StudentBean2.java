package com.linyuan.springbean.cofig;

import org.springframework.stereotype.Component;

/**
 * @Author DengXi
 * @Date 2021/2/19 10:42 上午
 * @desc:描述
 */
@Component(value = "StudentBean2")
public class StudentBean2 {
    public void System() {
        System.out.println("基于@Component注解的SpringBean的装配！");
    }
}
