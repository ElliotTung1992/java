package com.github.demo.java.proxy.jdk_proxy;

public class UserDao implements IUserDao{

    @Override
    public void save(String name) {
        System.out.println("开始存储.... name是:" + name);
    }
}
