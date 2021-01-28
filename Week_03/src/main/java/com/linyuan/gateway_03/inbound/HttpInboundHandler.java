package com.linyuan.gateway_03.inbound;

import com.linyuan.gateway_03.outbound.httpclient.HttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author DengXi
 * @Date 2021/1/27 2:23 下午
 * @desc:描述
 */
@Slf4j
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private static HttpOutboundHandler httpOutboundHandler = new HttpOutboundHandler();

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            httpOutboundHandler.handle(fullRequest, ctx);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
