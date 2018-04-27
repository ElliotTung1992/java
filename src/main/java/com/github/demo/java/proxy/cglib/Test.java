package com.github.demo.java.proxy.cglib;

public class Test {

    public static void main(String[] args) {
        //目标对象
        UserDao userDao = new UserDao();
        //获取代理对象
        ProxyFactory proxyFactory = new ProxyFactory(userDao);
        UserDao proxy = (UserDao) proxyFactory.getProxyInstance();
        //执行代理对象的方法
        proxy.save("hehe");
    }
}
