package com.linyuan.jeektime.rusticolusrpcclient.core.proxy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;

/**
 * @Author linyuan
 * @desc:描述
 */
public class ByteRubbyProxyRpcClient {
    public static <T> T create(final Class<T> serviceClass, final String url) throws Exception {

        return (T) new ByteBuddy().subclass(Object.class)
                .implement(serviceClass)
                .intercept(InvocationHandlerAdapter.of(new RpcInvocationHandler(serviceClass, url)))
                .make()
                .load(JavaProxyRpcClient.class.getClassLoader())
                .getLoaded()
                .getDeclaredConstructor()
                .newInstance();
    }
}