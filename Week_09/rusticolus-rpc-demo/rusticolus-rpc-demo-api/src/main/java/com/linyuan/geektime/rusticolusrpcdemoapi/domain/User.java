package com.linyuan.geektime.rusticolusrpcdemoapi.domain;

import lombok.Data;

/**
 * @Author linyuan
 * @desc:描述
 */
@Data
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}