package com.linyuan.concurrent.homenwore01;

import java.util.concurrent.Callable;

/**
 * @Author DengXi
 * @Date 2021/2/4 2:08 下午
 * @desc:描述
 */
public class Thread4 {

    public static void main(String[] args) throws Exception {
        // 使用Callable接口，利用Callable有结果
        Integer result = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return add(100);
            }
        }.call();
        System.out.println("异步得到结果：" + result);
        System.out.println("主线程执行完毕！");
    }

    public static Integer add(Integer num) {
        Integer result = 0;
        result += num;
        return result;
    }
}
