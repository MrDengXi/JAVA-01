package com.linyuan.concurrent.homenwore01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author DengXi
 * @Date 2021/2/4 2:31 下午
 * @desc:描述
 */
public class Thread8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 使用FutureTask
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return add(102);
            }
        });
        new Thread(task).start();
        System.out.println("异步结果为：" + task.get());
        System.out.println("主线程执行完毕！");
    }
    public static Integer add(Integer num) {
        Integer result = 0;
        result += num;
        return result;
    }
}
