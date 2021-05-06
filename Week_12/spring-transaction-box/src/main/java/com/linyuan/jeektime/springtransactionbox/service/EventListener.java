package com.linyuan.jeektime.springtransactionbox.service;

import com.google.common.eventbus.Subscribe;
import com.linyuan.jeektime.springtransactionbox.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author linyuan
 * @desc:描述
 */
@Slf4j
public class EventListener {
    @Subscribe
    public void listen1(OrderEntity orderEntity){
        log.info("listen1 receive: {}", orderEntity);
    }

    @Subscribe
    public void listen2(OrderEntity orderEntity){
        log.info("listen2 receive: {}", orderEntity);
    }
}