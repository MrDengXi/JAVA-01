package com.linyuan.geektime.dubbohmilytccapi;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author linyuan
 * @Date 2021/05/06 3:31 下午
 * @desc:描述
 */
@Data
public class Account implements Serializable {

    private long id;

    private long userId;

    private int type;

    private long freezeAmount;

    private long availableAmount;

    private long totalAmount;

    public Account() {
    }

    public Account(int type) {
        this.type = type;
    }
}