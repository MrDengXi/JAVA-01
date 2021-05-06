package com.linyuan.geektime.redisdistributedlock.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author linyuan
 * @desc:描述
 */
@Component
public class SimpleRedisLock implements RedisLock{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    @Override
    public boolean tryLock(String key, long timeout, TimeUnit unit) {
        String uuid = UUID.randomUUID().toString();
        threadLocal.set(uuid);
        return stringRedisTemplate.opsForValue().setIfPresent(key, uuid, timeout, unit);
    }

    @Override
    public void releaseLock(String key) {
        try {
            if (threadLocal.get().equals(stringRedisTemplate.opsForValue().get(key))) {
                stringRedisTemplate.delete(key);
            }
        } finally {
            threadLocal.remove();
        }
    }
}