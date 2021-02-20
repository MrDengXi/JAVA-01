package com.linyuan.spring.springbean.bean;

/**
 * @Author DengXi
 * @Date 2021/2/18 3:22 下午
 * @desc:描述
 */
public class Student {
    private int id;

    private String name;

    private int age;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void createStudent() {
//        this.age= 18;
//        this.id= 8765;
//        this.name = "李四";
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
