package com.linyuan.jeektime.rusticolusrpcclient.core.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author linyuan
 * @desc:描述
 */
public class JavaProxyRpcClient {

    public static <T> T create(final Class<T> serviceClass, final String url) throws Exception {
        return (T) Proxy.newProxyInstance(JavaProxyRpcClient.class.getClassLoader(),
                new Class[] { serviceClass},
                new RpcInvocationHandler(serviceClass, url));
    }
}