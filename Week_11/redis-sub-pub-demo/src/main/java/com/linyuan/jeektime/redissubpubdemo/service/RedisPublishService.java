package com.linyuan.jeektime.redissubpubdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author linyuan
 * @desc:描述
 */
@Service
@Slf4j
public class RedisPublishService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    boolean send(String topic, String data){
        redisTemplate.convertAndSend(topic, data);
        return true;
    }
}