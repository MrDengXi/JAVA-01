package com.linyuan.geektime.springcachedemo.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author linyuan
 * @desc:描述
 */
@Data
public class UserPO implements Serializable {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    private int id;
    private String name;

    public UserPO() {
    }

    public UserPO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserPO(String name) {
        this.name = name;
        this.id = generatorID();
    }

    public static int generatorID(){
        return atomicInteger.getAndIncrement();
    }
}