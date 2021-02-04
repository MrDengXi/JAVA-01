package com.linyuan.concurrent.homenwore01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author DengXi
 * @Date 2021/2/4 3:20 下午
 * @desc:描述
 */
public class Thread13 {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static Integer result = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            result = add(10001);
            lock.lock();
            condition.signal();
            lock.unlock();
        }).start();
        lock.lock();
        condition.await();
        lock.unlock();
        System.out.println("异步结果为：" + result);

        System.out.println("主线程执行完毕！");
    }

    public static Integer add(Integer num) {
        Integer result = 0;
        result += num;
        return result;
    }
}
