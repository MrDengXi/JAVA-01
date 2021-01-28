package com.linyuan.gateway_03.inbound;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author DengXi
 * @Date 2021/1/27 10:56 上午
 * @desc:描述
 */
@Slf4j
public class HttpInboundServer {

    public void run() {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup(32);

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap
                    // 组装两个消费组

                    // 设置channel类型
                    .channel(NioServerSocketChannel.class)
                    // 设置参数，客户端请求等待队列大小
                    .option(ChannelOption.SO_BACKLOG, 1000)
                    // 设置参数，是否发送活动探测数据报文
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    // 允许重复利用本地地址和端口
                    .option(EpollChannelOption.SO_REUSEADDR, true)
                    //禁止使用agle算法
                    .option(ChannelOption.TCP_NODELAY, true)
                    // 开启大小为 32 * 1024 缓存去读取数据跟发送数据
                    .option(ChannelOption.SO_RCVBUF, 32 * 1024)
                    .option(ChannelOption.SO_SNDBUF, 32 * 1024)
                    // 支持多个进程或者线程绑定到同一端口
                    .option(EpollChannelOption.SO_REUSEPORT, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // 使用对象池，重用缓冲区
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            bootstrap.group(boosGroup, workGroup).childHandler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new HttpInboundInitializer());
            Channel channel = bootstrap.bind(8080).sync().channel();
            log.info("开启netty http服务器，监听地址和端口为 http://127.0.0.1:8080/");
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
            boosGroup.shutdownGracefully();
        }

    }
}
