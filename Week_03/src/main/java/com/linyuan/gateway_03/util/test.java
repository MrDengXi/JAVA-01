package com.linyuan.gateway_03.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author DengXi
 * @Date 2021/2/1 6:56 下午
 * @desc:描述
 */
public class test {
    public static void main(String[] args) {
        User user = new User();
        List<User> list = new ArrayList();
        list.add(user);

        for (User user1 : list) {
            user1.setName("ZSan");
            user1.setAge(18);
        }
        System.out.println(list);
        User user1 = new User();
        demo1(user1);
        System.out.println(user1);
    }


     static void demo1(User user) {
         user.setName("ZSan");
         user.setAge(18);
         System.out.println("demo1 :" + user);
    }
}
