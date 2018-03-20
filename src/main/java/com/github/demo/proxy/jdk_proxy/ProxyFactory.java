package com.github.demo.proxy.jdk_proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 动态代理不需要实现接口,但是需要指定接口类型
 */
public class ProxyFactory {

    //目标对象
    private Object target;

    ProxyFactory(Object target){
        this.target = target;
    }

    //返回代理对象
    public Object returnInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开启事务");
                    Object result = method.invoke(target, args);
                    System.out.println("提交事务");
                    return result;
                }
        );
    }
}
