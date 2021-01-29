package com.linyuan.gateway_03.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author dengxi
 * @Date 2021/1/28 7:41 下午
 * @desc:描述
 */
public interface HttpRequestFilter {
    
    void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);
    
}
