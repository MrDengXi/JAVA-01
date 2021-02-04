package com.linyuan.concurrent.homenwore01;

/**
 * @Author DengXi
 * @Date 2021/2/3 1:59 下午
 * @desc:描述
 */
public class Thread2 {
    public static Integer sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            sum =+ add(100);
        });
        thread.start();
        // 使用wait阻塞主线程，等待异步线程执行完之后，拿到结果返回
        synchronized (thread) {
            thread.wait(0);
        }
        System.out.println("异步得到结果：" + sum);
        System.out.println("主线程执行完毕！");
    }

    public static Integer add(Integer num) {
        Integer result = 0;
        result += num;
        return result;
    }
}
