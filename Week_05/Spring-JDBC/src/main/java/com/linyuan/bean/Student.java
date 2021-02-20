package com.linyuan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author DengXi
 * @Date 2021/2/20 2:47 下午
 * @desc:描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;

    private String name;

    private int age;
}
