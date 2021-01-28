package com.linyuan.gateway_03.router.impl;

import com.linyuan.gateway_03.router.HttpEndpointRouter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author DengXi
 * @Date 2021/1/27 4:00 下午
 * @desc:描述
 */
public class HttpEndpointRouterImpl implements HttpEndpointRouter {

    private static List<String> urlList = Arrays.asList("http://localhost:8801", "http://localhost:8802", "http://localhost:8803");

    @Override
    public String route() {
        Random rd = new Random();
        int i = rd.nextInt(3);
        return urlList.get(i);
    }
}
