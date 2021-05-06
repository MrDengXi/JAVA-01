package com.linyuan.geektime.dubbohmilytccdemo.config;

import com.linyuan.geektime.dubbohmilytccdemo.annotation.DynamicSource;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @Author linyuan
 * @desc:描述
 */
public class DynamicDtatSOurceAnnotationInterceptor implements MethodInterceptor {

    @Nullable
    @Override
    public Object invoke(@Nonnull MethodInvocation methodInvocation) throws Throwable {
        try {
            String dsFlag = methodInvocation.getMethod().getAnnotation(DynamicSource.class).name();
            DynamicSourceContext.setDataSourceName(dsFlag);
            return methodInvocation.proceed();
        } finally {
            DynamicSourceContext.clearDataSource();
        }
    }
}