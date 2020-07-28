package com.github.demo.designPattern.proxy.cglib.test;

import org.springframework.cglib.proxy.CallbackHelper;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Method;

/**
 * @author 董感恩
 * @date 2020-07-28 14:20
 * @desc GBL能对final方法进行代理
 */
public class Test {

    private String desc;

    Test(String desc){
        this.desc = desc;
    }

    public String returnStr(){
        return "hello world";
    }

    public final String returnStrFinal(){
        return "final hello world";
    }

    public void noReturn(){
        System.out.println("木有返回值");
    }

    public static void main(String[] args) {
        //caseOne();
    }

    public final String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private static void caseOne() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Test.class);
        enhancer.setCallback((FixedValue) () -> "hello China");
        Class[] argumentTypes = {String.class};
        Object[] arguments = {"简单的练习"};
        Test testProxy = (Test) enhancer.create(argumentTypes, arguments);
        System.out.println(testProxy.getDesc());
        System.out.println(testProxy.returnStr());
        System.out.println(testProxy.toString());
        //不能够拦截final方法
        System.out.println(testProxy.getClass());
        System.out.println(testProxy.returnStrFinal());
        System.out.println(testProxy.hashCode());
    }
}
