package com.linyuan.concurrent.homenwore01;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author DengXi
 * @Date 2021/2/4 2:31 下午
 * @desc:描述
 */
public class Thread9 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // CompletableFuture
        Integer result = CompletableFuture.supplyAsync(Thread9::add).get();

        System.out.println("异步结果为：" + result);
        System.out.println("主线程执行完毕！");
    }

    static Integer add() {
        return 110;
    }
}

