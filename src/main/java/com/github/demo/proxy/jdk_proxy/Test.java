package com.github.demo.proxy.jdk_proxy;

public class Test {

    public static void main(String[] args) {

        IUserDao userDao = new UserDao();

        System.out.println(userDao.getClass());

        ProxyFactory proxyFactory = new ProxyFactory(userDao);

        IUserDao proxy = (IUserDao) proxyFactory.returnInstance();

        System.out.println(proxy.getClass());

        proxy.save("feng");
    }
}
