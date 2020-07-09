package com.github.demo.designPattern.proxy.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 董感恩
 * @date 2020-07-09 11:09
 * @desc
 */
public class TimeInvocationHandler implements InvocationHandler{

    private Object target;

    TimeInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public void invoke(Object proxy, Method method, Object[] args) {
        long start = System.currentTimeMillis();
        try {
            method.invoke(target, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("Cost time:" + (System.currentTimeMillis() - start));
    }
}
