package com.linyuan.geektime.rusticolusrpcdemoapi.service;

import com.linyuan.geektime.rusticolusrpcdemoapi.domain.User;

/**
 * @Author linyuan
 * @desc:描述
 */
public interface UserService {
    User findUserById(int id);
}
