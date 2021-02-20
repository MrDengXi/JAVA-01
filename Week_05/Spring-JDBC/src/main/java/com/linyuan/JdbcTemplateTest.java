package com.linyuan;

import com.linyuan.bean.Student;
import com.linyuan.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author DengXi
 * @Date 2021/2/20 3:17 下午
 * @desc:描述
 */
public class JdbcTemplateTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-student.xml");
        StudentDao studentDao = (StudentDao) context.getBean("StudentDao");
        // 新增记录
        studentDao.insert(new Student(1, "张三", 21));
        // 查询
        System.out.println(studentDao.findById(1));
        // 修改记录
        studentDao.updateById(new Student(1, "张三丰", 1221));
        System.out.println(studentDao.findById(1));
        // 删除
        studentDao.deleteById(1);
        System.out.println(studentDao.findById(1));
    }
}
