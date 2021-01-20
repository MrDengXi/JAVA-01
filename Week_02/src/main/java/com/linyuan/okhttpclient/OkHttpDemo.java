package com.linyuan.okhttpclient;

import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author DengXi
 * @Date 2021/1/20 10:22 上午
 * @desc:描述
 */
public class OkHttpDemo {

    public static final String BASEURL1 = "http://localhost:8801";

    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(BASEURL1).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {

            }

            public void onResponse(Call call, Response response) throws IOException {
                // 输出 hello,nio
                System.out.println(response.body().string());
            }
        });

    }
}
