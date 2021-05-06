package com.linyuan.geektime.dubbohmilytccdemo.annotation;

import java.lang.annotation.*;

/**
 * @Author linyuan
 * @desc:描述
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicSource {
    String name() default "";
}
