package com.github.demo.designPattern.proxy.self_dynamic_proxy;

import com.github.demo.designPattern.proxy.simple_demo.Bird;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 董感恩
 * @date 2020-07-08 16:53
 * @desc
 */
public class MyInvocationHandler implements InvocationHandler{

    private Bird bird;

    public MyInvocationHandler(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void invoke(Object proxy, Method method, Object[] args) {
        long start = System.currentTimeMillis();
        try {
            method.invoke(bird, new Object[] {});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}
