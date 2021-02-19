package com.linyuan.springbean.cofig;

import com.linyuan.springbean.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author DengXi
 * @Date 2021/2/19 10:23 上午
 * @desc:描述 基于注解装配bean
 */
@Configuration
public class ConfigByAnnotation {

    /**
     * 注解方式注册spring bean
     */
    @Bean(value = "getStudent")
    public Student getStudent() {
        return new Student(9988, "张三丰", 101);
    }
}
