package com.linyuan.concurrent.homenwore01;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author DengXi
 * @Date 2021/2/4 3:20 下午
 * @desc:描述
 */
public class Thread14 {
    static Integer result = 0;
    static Semaphore semaphore = new Semaphore(50);
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            semaphore.release(50);

            try {
                result = add(10001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        semaphore.acquire(99);
        System.out.println("异步结果为：" + result);

        System.out.println("主线程执行完毕！");
    }

    public static Integer add(Integer num) throws InterruptedException {
        //Thread.sleep(100);
        Integer result = 0;

        for (int i = 0; i < 100; i++) {
            result++;
        }
        result += num;
        return result;
    }

}
