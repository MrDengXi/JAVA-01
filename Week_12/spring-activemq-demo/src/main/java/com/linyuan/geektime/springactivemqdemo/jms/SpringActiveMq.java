package com.linyuan.geektime.springactivemqdemo.jms;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @Author linyuan
 * @desc:描述
 */
@Service
@Slf4j
public class SpringActiveMq {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendTopicMessage(String message) {
        sendTopicMessage("test.topic", message);
    }

    public void sendTopicMessage(String topic, String message){
        log.info("send to topic[{}], message: {}", topic, message);
        Destination destination = new ActiveMQTopic(topic);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    public void sendQueueMessage(String message){
        sendQueueMessage("test.queue", message);
    }

    public void sendQueueMessage(String queue, String message){
        log.info("send to queue[{}], message: {}", queue, message);
        Destination destination = new ActiveMQQueue(queue);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    @JmsListener(destination = "test.topic", containerFactory = "topicListenerContainerFactory")
    public void receiveTopicMessage(String text){
        log.info("receive message: {}", text);
    }

    @JmsListener(destination = "test.queue", containerFactory = "queueListenerContainerFactory")
    public void receiveQueueMessage(String text){
        log.info("receive message: {}", text);
    }

    @Scheduled(fixedRate = 5000)
    public void init(){
        sendQueueMessage("hello, queue");
        sendTopicMessage("hello, topic");
    }
}