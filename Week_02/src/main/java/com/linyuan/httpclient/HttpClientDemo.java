package com.linyuan.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * @Author DengXi
 * @Date 2021/1/20 9:59 上午
 * @desc:描述 使用HttpClient模拟浏览器发请求
 */
public class HttpClientDemo {
    public static final String URL = "http://127.0.0.1:8801";

    public static void main(String[] args) throws IOException {
        // 创建HttpClient
        HttpClient httpClient = HttpClients.createDefault();
        // 发送请求建立连接 get请求
        HttpGet httpGet = new HttpGet(URL);
        // 获得本地8801的结果
        HttpResponse response = httpClient.execute(httpGet);
        System.out.println(response);
    }
}
