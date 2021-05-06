package com.linyuan.geektime.dubbohmilytccdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author linyuan
 * @desc:描述
 */
@Data
@Entity
@Table(name = "t_frozen")
public class FrozenPO implements Serializable {
    private static final long serialVersionUID = 661434701950670670L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "account_type")
    private Integer accountType;
}