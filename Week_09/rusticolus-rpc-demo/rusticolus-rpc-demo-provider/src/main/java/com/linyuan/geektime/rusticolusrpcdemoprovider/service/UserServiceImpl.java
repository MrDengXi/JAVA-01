package com.linyuan.geektime.rusticolusrpcdemoprovider.service;

import com.linyuan.geektime.rusticolusrpcdemoapi.domain.User;
import com.linyuan.geektime.rusticolusrpcdemoapi.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author linyuan
 * @desc:描述
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(int id) {
        return new User(id, "linyuan");
    }
}