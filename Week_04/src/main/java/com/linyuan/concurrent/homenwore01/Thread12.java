package com.linyuan.concurrent.homenwore01;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author DengXi
 * @Date 2021/2/4 3:12 下午
 * @desc:描述
 */
public class Thread12 {
    private static Integer result = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1, false);
        new Thread(() -> {
            result = add(12306);
            atomicInteger.incrementAndGet();
        }).start();
        while (atomicInteger.get() % 2 != 0) {

        }
        semaphore.acquire();
        System.out.println("异步结果为：" + result);
        System.out.println("主线程执行完毕！");
    }
    public static Integer add(Integer num) {
        Integer result = 0;
        result += num;
        return result;
    }
}
