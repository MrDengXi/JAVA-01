package com.linyuan.jeektime.rusticolusrpcclient.core.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author linyuan
 * @desc:描述
 */
@Slf4j
public class NettyResponseHandler extends ChannelInboundHandlerAdapter {

    private final FullHttpResponseFuture httpResponseFuture;

    public NettyResponseHandler(FullHttpResponseFuture httpResponseFuture){
        this.httpResponseFuture = httpResponseFuture;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        httpResponseFuture.setSuccess((FullHttpResponse) msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}