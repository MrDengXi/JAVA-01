package com.linyuan.springbean.cofig;

import com.linyuan.springbean.bean.Student;

import javax.annotation.Resource;

/**
 * @Author DengXi
 * @Date 2021/2/19 10:29 上午
 * @desc:描述
 */
public class StudentBean {
    @Resource(name = "getStudent")
    Student student;

    public void System() {
        System.out.println(student);
    }
}
