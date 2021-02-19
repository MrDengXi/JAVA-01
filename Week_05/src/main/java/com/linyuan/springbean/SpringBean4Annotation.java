package com.linyuan.springbean;

import com.linyuan.springbean.bean.Student;
import com.linyuan.springbean.cofig.StudentBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * @Author DengXi
 * @Date 2021/2/19 10:26 上午
 * @desc:描述
 */
public class SpringBean4Annotation {

    public static void main(String[] args) {
        // 根据xml文件初始化Spring上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        // 根据xml中配置的有参构造获取对应的bean
        StudentBean studentBean = (StudentBean) context.getBean("student-bean");
        studentBean.System();
    }

}
