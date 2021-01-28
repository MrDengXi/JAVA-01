package com.linyuan.gateway_03.inbound;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Author DengXi
 * @Date 2021/1/27 11:31 上午
 * @desc:描述
 */
public class HttpInboundInitializer extends ChannelInitializer<NioSocketChannel> {

    @Override
    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
        nioSocketChannel.pipeline().addLast(new HttpServerCodec())
                .addLast(new HttpObjectAggregator(1024 * 1024))
                .addLast(new HttpInboundHandler());
    }
}
