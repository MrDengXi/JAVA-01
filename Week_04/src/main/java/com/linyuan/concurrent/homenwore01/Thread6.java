package com.linyuan.concurrent.homenwore01;

import java.util.concurrent.*;

/**
 * @Author DengXi
 * @Date 2021/2/4 2:28 下午
 * @desc:描述
 */
public class Thread6 {
    public static void main(String[] args) throws Exception {
        // 利用Future
        ExecutorService executorService = new ThreadPoolExecutor(1,1,1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return add(101);
            }
        });
        executorService.shutdown();
        System.out.println("异步结果为：" + future.get());
        System.out.println("主线程执行完毕！");
    }

    public static Integer add(Integer num) {
        Integer result = 0;
        result += num;
        return result;
    }
}
