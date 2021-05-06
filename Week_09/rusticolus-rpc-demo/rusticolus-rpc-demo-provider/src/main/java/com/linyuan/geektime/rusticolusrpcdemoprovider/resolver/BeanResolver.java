package com.linyuan.geektime.rusticolusrpcdemoprovider.resolver;

import com.linyuan.jeektime.rusticolusrpccommon.resolver.RpcResolver;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author linyuan
 * @desc:描述
 */
@Component
public class BeanResolver implements RpcResolver, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public Object resolve(String serviceName) {
        return applicationContext.getBean(serviceName);
    }

    @Override
    public Object resolve(Class<?> clazz){
        return applicationContext.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}