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
public class JdbcHikariTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-hikari.xml");
        StudentDao studentDao = (StudentDao) context.getBean("StudentDao1");
        for (int i = 0; i <= 100; i++) {
            int finalI = i;
            new Thread(() -> {
                // 新增记录
                studentDao.insert(new Student(finalI, "张三" +finalI, 21));
                // 查询
                System.out.println(studentDao.findById(finalI));
                // 修改记录
                studentDao.updateById(new Student(finalI, "张三丰" + finalI, 1221));
                System.out.println(studentDao.findById(finalI));
                // 删除
                studentDao.deleteById(finalI);
                System.out.println(studentDao.findById(finalI));
            }).start();
        }
    }
}
