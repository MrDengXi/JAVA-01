package com.linyuan.spring.springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Author DengXi
 * @Date 2021/2/19 10:08 上午
 * @desc:描述
 */
@Aspect
public class Aop2 {
    @Pointcut(value = "execution(* com.linyuan.spring.springaop.aopdemo.*.*(..))")
    public void point() {

    }

    @Before(value = "point()")
    public void before() {
        System.out.println("基于注解的Aop前置通知 ===> start Aop");
    }

    @After(value = "point()")
    public void after() {
        System.out.println("基于注解的Aop后置通知 ===> finish Aop");
    }

    @Around(value = "point()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("基于注解的Aop环绕通知 ===> start Aop");
        joinPoint.proceed();
        System.out.println("基于注解的Aop环绕通知 ===> finish Aop");
    }
}
