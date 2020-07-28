package com.github.demo.designPattern.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 董感恩
 * @date 2020-07-28 14:07
 * @desc
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    CglibProxy(Object target){
        this.target = target;
    }

    public Object newInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        Object proxy = enhancer.create();
        return proxy;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始拦截");
        Object result = method.invoke(target, args);
        System.out.println("结束拦截");
        return result;
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        CglibProxy cglibProxy = new CglibProxy(dog);
        Dog dogProxy = (Dog) cglibProxy.newInstance();
        dogProxy.run();
        System.out.println(dogProxy.takeFrisbee("走你"));
    }
}
