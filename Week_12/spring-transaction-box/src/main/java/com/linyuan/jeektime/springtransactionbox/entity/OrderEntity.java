package com.linyuan.jeektime.springtransactionbox.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author linyuan
 * @desc:描述
 */
@Data
@ToString
public class OrderEntity implements Serializable {
    private Long id;
    private String name;
    private Long totalMoney;
    private Long userId;
    private Integer status;
}