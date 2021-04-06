package com.linyuan.geektime.xa2pcsharding.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author DengXi
 * @Date 2021/3/7 11:00 下午
 * @desc:描述
 */
@Data
public class Orders {
    private Long id;

    private Long userId;

    private BigDecimal amount;

    private int status;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;
}
