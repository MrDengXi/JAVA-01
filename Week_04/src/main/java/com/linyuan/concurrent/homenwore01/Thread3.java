package com.linyuan.concurrent.homenwore01;

/**
 * @Author DengXi
 * @Date 2021/2/4 2:04 下午
 * @desc:描述
 */
public class Thread3 {
    public static Integer sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            sum =+ add(100);
        });
        thread.start();
        // 判断异步线程是否还存活，存活，主线程就继续在这循环，执行完，可拿到结果
        while (thread.isAlive()) {

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
