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
@Table(name = "t_user")
public class UserPO implements Serializable {
    private static final long serialVersionUID = 661434701950670670L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
}