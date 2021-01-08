package com.linyuan.classloader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @Author dengxi
 * @Date 2021/1/8 4:29 下午
 * @desc:描述
 */
public class HelloClassLoader extends ClassLoader  {
    public static void main(String[] args) {
        try {
            Class<?> helloClass = new HelloClassLoader().findClass("Hello");
            Method method = helloClass.getDeclaredMethod("hello");
            method.invoke(helloClass.newInstance());
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[0];
        try {
            bytes = processData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] processData(String name) throws IOException {
        // 获取流
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(name + ".xlass");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int n = 0;
        if(inputStream != null) {
            while ((n = inputStream.read()) != -1) {
                output.write(255 - n);
            }
        }
        return output.toByteArray();
    }
}
