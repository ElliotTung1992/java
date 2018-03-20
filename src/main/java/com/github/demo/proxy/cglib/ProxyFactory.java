package com.github.demo.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理 动态地给目标对象创建一个子类(代理对象)对象来扩展目标对象
 */
public class ProxyFactory implements MethodInterceptor{

    //目标对象
    private Object target;

    public ProxyFactory(Object obj){
        this.target = obj;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类(代理对象)
        return enhancer.create();
    }

    //拦截
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        Object result = method.invoke(target, args);
        System.out.println("提交事务");
        return result;
    }
}
