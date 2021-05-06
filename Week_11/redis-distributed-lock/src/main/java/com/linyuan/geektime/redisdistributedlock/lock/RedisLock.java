package com.linyuan.geektime.redisdistributedlock.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Author linyuan
 * @desc:描述
 */
public interface RedisLock {
    /**
     * 尝试加锁
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    boolean tryLock(String key, long timeout, TimeUnit unit);

    /**
     * 解锁操作
     * @param key
     */
    void releaseLock(String key);
}
