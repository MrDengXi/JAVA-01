package com.linyuan.geektime.springkafkademo.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author linyuan
 * @desc:描述
 */
@Data
@ToString
public class Order implements Serializable {
    private int id;

    private String name;
}