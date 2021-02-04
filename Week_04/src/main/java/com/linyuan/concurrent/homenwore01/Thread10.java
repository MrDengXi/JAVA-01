package com.linyuan.concurrent.homenwore01;

import java.util.concurrent.CountDownLatch;

/**
 * @Author DengXi
 * @Date 2021/2/4 2:31 下午
 * @desc:描述
 */
public class Thread10 {
    private static Integer result = 0;
    public static void main(String[] args) throws InterruptedException {
        // 使用CountDownLatch线程计数器
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            result = add(119);
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();

        System.out.println("异步结果为：" + result);
        System.out.println("主线程执行完毕！");
    }

    public static Integer add(Integer num) {
        Integer result = 0;
        result += num;
        return result;
    }
}
