package com.linyuan.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author DengXi
 * @Date 2021/2/19 5:19 下午
 * @desc:描述
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "starter.demo")
public class StarterDemoProperties {
    private String userName = "钻石王老五";

    private String desc = "身家百亿";
}
