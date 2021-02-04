package com.linyuan.concurrent.homenwore01;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author DengXi
 * @Date 2021/2/4 2:31 下午
 * @desc:描述
 */
public class Thread11 {
    private static Integer result = 0;
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        // 使用CyclicBarrier线程栅栏
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(() -> {
            result = add(120);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        cyclicBarrier.await();
        System.out.println("异步结果为：" + result);
        System.out.println("主线程执行完毕！");
    }

    public static Integer add(Integer num) {
        Integer result = 0;
        result += num;
        return result;
    }
}
