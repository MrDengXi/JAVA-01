package com.linyuan.spring.springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Author DengXi
 * @Date 2021/2/18 4:45 下午
 * @desc:描述
 */
public class Aop1 {

    /**
     * 前置通知
     */
    public void beforeTransaction() {
        System.out.println("Aop前置通知 ===> start Aop");
    }

    /**
     * 后置通知
     */
    public void afterTransaction() {
        System.out.println("Aop后置通知 ===> finish Aop");
    }

    /**
     * 环绕通知
     */
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Aop环绕通知 ===> around start Aop");
        //调用process()方法才会真正的执行实际被代理的方法
        joinPoint.proceed();
        System.out.println("Aop环绕通知 ===> around finish Aop");
    }
}
