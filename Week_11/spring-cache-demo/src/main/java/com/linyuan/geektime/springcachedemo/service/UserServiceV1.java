package com.linyuan.geektime.springcachedemo.service;

import com.linyuan.geektime.springcachedemo.domain.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

/**
 * @Author linyuan
 * @desc:描述
 */
@Service
public class UserServiceV1 {

    private static final String USER_KEY = "USERS";

    @Resource
    private RedisTemplate redisTemplate;

    public UserPO save(UserPO userPO){
        userPO.setId(UserPO.generatorID());

        redisTemplate.opsForHash().put(USER_KEY, userPO.getId(), userPO);

        return userPO;
    }

    public UserPO getByUserId(int userId){
        return (UserPO)redisTemplate.opsForHash().get(USER_KEY, userId);
    }

    public UserPO update(UserPO userPO){
        redisTemplate.opsForHash().put(USER_KEY, userPO.getId(), userPO);
        return userPO;
    }

    public void delete(int userId){
        redisTemplate.opsForHash().delete(USER_KEY, userId);
    }
}