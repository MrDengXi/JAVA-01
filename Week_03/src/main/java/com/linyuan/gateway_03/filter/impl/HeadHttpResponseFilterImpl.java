package com.linyuan.gateway_03.filter.impl;

import com.linyuan.gateway_03.filter.HttpRequestFilter;
import com.linyuan.gateway_03.filter.HttpResponseFilter;
import com.linyuan.gateway_03.util.ThreadLocalUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledHeapByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @Author DengXi
 * @Date 2021/1/28 7:41 下午
 * @desc:描述
 */
public class HeadHttpResponseFilterImpl implements HttpResponseFilter {
    private final String HelloWorld = "Hello, world!";

    @Override
    public void filter(FullHttpResponse response, ChannelHandlerContext ctx) {
//        Long startTime = (Long) ctx.;
//        System.out.println("请求时间：" + String.valueOf(System.currentTimeMillis() - startTime));
        byte[] bytes = HelloWorld.getBytes();
        ByteBuf buf = Unpooled.buffer(response.content().readableBytes() + bytes.length);
        response.content().maxCapacity();
        buf.writeBytes(bytes);
        response.headers().set("Content-Type", "application/json");
        response.headers().setInt("Content-Length", response.content().readableBytes());
        response.content().writeBytes(buf,0,13);
    }
}
