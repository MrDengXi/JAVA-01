package com.linyuan.mysql02.aop;

import com.linyuan.mysql02.annotation.DataSource2;
import com.linyuan.mysql02.datasourceroute.DBContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author DengXi
 * @Date 2021/3/8 9:47 上午
 * @desc:描述
 */
@Component
public class MapperAop {
    @Autowired
    private DBContextHolder contextHolder;

    @Around("execution (* com.linyuan.mysql02.service.*(..))")
    public Object setRoutingKeyAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        DataSource2 dataSource2 = method.getAnnotation(DataSource2.class);

        if (dataSource2 != null) {
            contextHolder.useDataSource2();
        }

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            contextHolder.clear();
        }
        return result;
    }
}
