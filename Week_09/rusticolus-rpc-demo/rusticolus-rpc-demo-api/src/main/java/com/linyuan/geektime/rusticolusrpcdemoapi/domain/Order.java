package com.linyuan.geektime.rusticolusrpcdemoapi.domain;

import lombok.Data;

/**
 * @Author linyuan
 * @desc:描述
 */
@Data
public class Order {
    private int id;

    private String name;

    private float amount;

    public Order(int id, String name, float amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
}