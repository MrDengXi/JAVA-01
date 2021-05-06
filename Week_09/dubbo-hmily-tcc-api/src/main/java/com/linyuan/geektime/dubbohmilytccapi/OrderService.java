package com.linyuan.geektime.dubbohmilytccapi;

/**
 * @Author linyuan
 * @Date 2021/05/06 3:31 下午
 * @desc:描述
 */
public interface OrderService {

    void transfer(Account from, long amount, Account to);

    void transfer();
}
