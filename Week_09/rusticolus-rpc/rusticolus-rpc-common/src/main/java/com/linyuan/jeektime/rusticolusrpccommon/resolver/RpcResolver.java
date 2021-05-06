package com.linyuan.jeektime.rusticolusrpccommon.resolver;

/**
 * @Author linyuan
 * @desc:描述
 */
public interface RpcResolver {
    Object resolve(String serviceName);

    Object resolve(Class<?> clazz);
}
