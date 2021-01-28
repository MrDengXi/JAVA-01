package com.linyuan.gateway_03;

import com.linyuan.gateway_03.inbound.HttpInboundServer;

/**
 * @Author DengXi
 * @Date 2021/1/27 2:47 下午
 * @desc:描述
 */
public class NettyServerApplication {
    public static void main(String[] args) {
        HttpInboundServer httpInboundServer = new HttpInboundServer();
        httpInboundServer.run();
    }
}
