package com.linyuan.gateway_03.filter.impl;

import com.linyuan.gateway_03.filter.HttpRequestFilter;
import com.sun.net.httpserver.HttpContext;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @Author DengXi
 * @Date 2021/1/28 7:41 下午
 * @desc:描述
 */
public class HttpRequestFilterImpl implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
//        ThreadLocalUtil.threadLocal.set(System.currentTimeMillis());
//        HttpContext
        ctx.write(System.currentTimeMillis());
        fullRequest.headers().set("From", "Request from LinYuan");

    }
}
