package com.linyuan.geektime.springkafkademo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author linyuan
 * @desc:描述
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "test.order.topic", groupId = "1")
    public void receiveMessage(ConsumerRecord<?, ?> record){
        Optional<?> kafkaMessage = Optional.ofNullable(record);
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("receive msg: {}", message);
        }
    }
}