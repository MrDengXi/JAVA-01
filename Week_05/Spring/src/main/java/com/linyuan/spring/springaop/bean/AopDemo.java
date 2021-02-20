package com.linyuan.spring.springaop.bean;

import com.linyuan.spring.springaop.aopdemo.AopInterfaceDemo;

/**
 * @Author DengXi
 * @Date 2021/2/18 5:06 下午
 * @desc:描述
 */
public class AopDemo implements AopInterfaceDemo {
    public void aopMethod() {
        System.out.println("我是一个Spring Bean！");
    }
}
