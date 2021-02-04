package com.linyuan.concurrent.homenwore01;

/**
 * @Author DengXi
 * @Date 2021/2/1 2:56 下午
 * @desc:描述
 */
public class Thread1 {
    public static Integer sum = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            sum =+ add(100);
        });
        thread.start();
        // 使用join阻塞主线程，等到异步线程执行完后，拿到结果
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
