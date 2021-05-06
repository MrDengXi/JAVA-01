package com.linyuan.geektime.dubbohmilytccapi;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author linyuan
 * @Date 2021/05/06 3:32 下午
 * @desc:描述
 */
@Data
public class User implements Serializable {
    private Long id;
    private String name;
    private List<Account> accountList;

    public User() {
        accountList = new ArrayList<>();
    }

    public void add(Account account){
        this.accountList.add(account);
    }
}