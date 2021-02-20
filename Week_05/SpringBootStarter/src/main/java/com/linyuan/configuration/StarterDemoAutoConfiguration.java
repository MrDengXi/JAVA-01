package com.linyuan.configuration;

import com.linyuan.bean.User;
import com.linyuan.properties.StarterDemoProperties;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Author DengXi
 * @Date 2021/2/19 5:17 下午
 * @desc:描述
 */
@Configuration
@EnableConfigurationProperties(StarterDemoProperties.class)
public class StarterDemoAutoConfiguration implements DisposableBean {
    @Resource
    private StarterDemoProperties properties;

    @Bean(name = "userDemo")
    public User userDemo() {
        System.out.println("调用SpringBootStarter的自定义方法");
        printDesc();
        return new User(properties.getUserName(), properties.getDesc());
    }

    private void printDesc() {
        System.out.println("姓名：" + properties.getUserName() + "，描述：" + properties.getDesc());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用SpringBootStarter的destroy方法");
    }
}
