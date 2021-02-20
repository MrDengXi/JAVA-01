package com.linyuan.spring.springaop;

import com.linyuan.spring.springaop.aopdemo.AopInterfaceDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author DengXi
 * @Date 2021/2/18 5:05 下午
 * @desc:描述
 */
public class SpringAop4Xml {
    public static void main(String[] args) {
        // 根据xml文件初始化Spring上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        AopInterfaceDemo aopDemo = (AopInterfaceDemo) context.getBean("aopDemo");
        aopDemo.aopMethod();
    }
}
