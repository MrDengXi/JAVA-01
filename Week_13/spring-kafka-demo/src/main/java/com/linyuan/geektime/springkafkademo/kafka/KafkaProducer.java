package com.linyuan.geektime.springkafkademo.kafka;

import com.alibaba.fastjson.JSON;
import com.linyuan.geektime.springkafkademo.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author linyuan
 * @desc:描述
 */
@Component
@Slf4j
@EnableScheduling
public class KafkaProducer {

    private static AtomicInteger adder = new AtomicInteger(0);

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    public void send(String topic, String message){
        kafkaTemplate.send(topic, message.hashCode(), message);
    }


    @Scheduled(fixedRate = 5000)
    public void sendMessage(){
        send("test.order.topic", JSON.toJSONString(createOrder()));
    }

    private Order createOrder(){
        Order order = new Order();
        order.setId(adder.getAndIncrement());
        order.setName("order" + adder);
        return order;
    }
}