package com.github.demo.java.proxy.cglib;

public class UserDao {

    public void save(String name){
        System.out.println("开始存储.... name是:" + name);
    }
}
