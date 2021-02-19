package com.linyuan.springbean;

import com.linyuan.springbean.bean.Student;
import com.linyuan.springbean.cofig.StudentBean2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author DengXi
 * @Date 2021/2/19 10:26 上午
 * @desc:描述
 */
public class SpringBean4Annotation {
    public static void main(String[] args) {
        // 根据xml文件初始化Spring上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

        // 基于 @Configuration 跟 @Bean 的spring bean的装载
        Student studentBean = (Student) context.getBean("getStudent");
        System.out.println(studentBean);

        // 基于 @Component 的spring bean装配
        StudentBean2 studentBean1 = (StudentBean2) context.getBean("StudentBean2");
        studentBean1.System();
    }

}
