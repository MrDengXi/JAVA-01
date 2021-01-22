package com.linyuan.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

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
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 发送请求建立连接 get请求
        HttpGet httpGet = new HttpGet("http://localhost:8801");
        // 获得本地8801的结果
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();

            String entityString = EntityUtils.toString(entity, "utf-8");
            System.out.println(entityString);
        }
        response.close();
        httpClient.close();
        //System.out.println(response);
    }
}
