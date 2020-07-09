package com.github.demo.designPattern.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 董感恩
 * @date 2020-07-09 10:08
 * @desc 日志代理
 */
public class LogInvocationHandler implements InvocationHandler {

    private Object target;

    LogInvocationHandler(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this::invoke);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //if(method.getName() == "addSubject"){
            System.out.println("进行数据监听");
        //}
        return method.invoke(target, args);
    }
}
