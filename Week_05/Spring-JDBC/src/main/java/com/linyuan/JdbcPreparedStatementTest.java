package com.linyuan;

import com.linyuan.bean.Student;
import com.linyuan.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author DengXi
 * @Date 2021/2/20 4:10 下午
 * @desc:描述
 */
public class JdbcPreparedStatementTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-student.xml");
        StudentDao studentDao = (StudentDao) context.getBean("StudentDao1");

        // 新增记录
        studentDao.insert(new Student(2, "李四", 21));
        // 查询
        System.out.println(studentDao.findById(2));
        // 修改记录
        studentDao.updateById(new Student(2, "李四瘪", 1221));
        System.out.println(studentDao.findById(2));
        // 删除
        studentDao.deleteById(2);
        System.out.println(studentDao.findById(2));
    }
}
