package com.linyuan.springbean;

import com.linyuan.springbean.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author DengXi
 * @Date 2021/2/18 3:20 下午
 * @desc:描述 通过xml方式装配Spring Bean
 */
public class SpringBean4Xml {

    public static void main(String[] args) {
        // 根据xml文件初始化Spring上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        // 根据xml中配置的有参构造获取对应的bean
        Student student1 = (Student) context.getBean("student1");
        System.out.println(student1);

        // 根据xml配置的property装载bean
        Student student2 = (Student) context.getBean("student2");
        System.out.println(student2);

        // 通过 init-method 初始化bean
        Student student3 = (Student) context.getBean("student3");
        System.out.println(student3);
    }
}
