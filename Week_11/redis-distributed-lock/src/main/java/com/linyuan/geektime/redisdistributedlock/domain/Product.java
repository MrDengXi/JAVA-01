package com.linyuan.geektime.redisdistributedlock.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author linyuan
 * @desc:描述
 */
@Data
@ToString
public class Product implements Serializable {

    private int id;

    private String name;

    private int count;

    public Product() {
    }

    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public Product(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
}