package com.linyuan.geektime.springactivemqdemo.config;

import org.apache.activemq.xbean.BrokerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @Author linyuan
 * @desc:描述
 */
@Configuration
public class ActivemqConfig {

    @Bean
    public BrokerFactoryBean activemq() throws Exception{
        BrokerFactoryBean brokerFactoryBean = new BrokerFactoryBean();
        brokerFactoryBean.setConfig(new ClassPathResource("activemq.xml"));
        brokerFactoryBean.setStart(true);

        return brokerFactoryBean;
    }
}