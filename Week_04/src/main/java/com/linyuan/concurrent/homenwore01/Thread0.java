package com.linyuan.concurrent.homenwore01;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author DengXi
 * @Date 2021/2/4 3:20 下午
 * @desc:描述
 */
public class Thread0 {
    static Integer result = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            result = add(123123);
        }).start();

        Thread.sleep(TimeUnit.MILLISECONDS.toMillis(100));
        System.out.println("异步得到结果：" + result);
        System.out.println("主线程执行完毕！");
    }

    public static Integer add(Integer num) {
        Integer result = 0;
        result += num;
        return result;
    }
}
