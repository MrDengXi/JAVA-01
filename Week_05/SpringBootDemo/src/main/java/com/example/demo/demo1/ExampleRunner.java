package com.example.demo.demo1;

import com.linyuan.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author DengXi
 * @Date 2021/2/19 7:37 下午
 * @desc:描述
 */
@Component
public class ExampleRunner implements ApplicationRunner {
    @Autowired
    private User startDemo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("aaa");
        System.out.println(startDemo);
    }
}
