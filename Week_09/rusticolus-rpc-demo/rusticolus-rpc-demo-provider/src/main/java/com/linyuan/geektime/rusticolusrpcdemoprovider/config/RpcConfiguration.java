package com.linyuan.geektime.rusticolusrpcdemoprovider.config;

import com.linyuan.jeektime.rusticolusrpccommon.resolver.RpcResolver;
import com.linyuan.jeektime.rusticolusrpcserver.core.RpcServerInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author linyuan
 * @desc:描述
 */
@Configuration
public class RpcConfiguration {
    @Bean
    public RpcServerInvoker invocationHandler(@Autowired RpcResolver resolver){
        return new RpcServerInvoker(resolver);
    }
}