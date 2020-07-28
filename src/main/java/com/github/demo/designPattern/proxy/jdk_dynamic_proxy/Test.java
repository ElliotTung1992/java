package com.github.demo.designPattern.proxy.jdk_dynamic_proxy;

/**
 * @author 董感恩
 * @date 2020-07-09 10:12
 * @desc
 */
public class Test {

    public static void main(String[] args) {
        RealSubject subject = new RealSubject();
        LogInvocationHandler invocationHandler = new LogInvocationHandler(subject);
        Subject proxyInstance = (Subject) invocationHandler.getProxyInstance();
        proxyInstance.addSubject();
        proxyInstance.getSubjectCount();
    }
}
