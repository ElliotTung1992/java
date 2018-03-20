package com.github.demo.proxy.static_proxy;

public class UserDaoProxy implements IUserDao{

    private UserDao userDao;

    public UserDaoProxy(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void save(String name) {
        System.out.println("开始事务");
        userDao.save(name);
        System.out.println("提交事务");
    }
}
