package com.linyuan.geektime.dubbohmilytccdemo.service;

import com.linyuan.geektime.dubbohmilytccapi.Account;
import com.linyuan.geektime.dubbohmilytccapi.User;
import com.linyuan.geektime.dubbohmilytccapi.UserService;
import com.linyuan.geektime.dubbohmilytccapi.AccountType;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Author linyuan
 * @desc:描述
 */
@DubboService(version = "1.0.0", retries = 0)
public class UserServiceImpl implements UserService {
    @Override
    public User findById(long id) {
        User user = new User();
        user.setId(id);
        user.setName("linyuan");

        Account cny = new Account();
        cny.setUserId(id);
        cny.setType(AccountType.CNY);
        cny.setAvailableAmount(100);
        cny.setFreezeAmount(100);
        cny.setTotalAmount(cny.getFreezeAmount() + cny.getAvailableAmount());

        Account usb = new Account();
        usb.setUserId(id);
        usb.setType(AccountType.USD);
        usb.setAvailableAmount(200);
        usb.setFreezeAmount(200);
        usb.setTotalAmount(usb.getFreezeAmount() + usb.getAvailableAmount());

        user.add(cny);
        user.add(usb);

        return user;
    }
}