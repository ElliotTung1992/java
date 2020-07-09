package com.github.demo.designPattern.proxy.simple_demo;

/**
 * @author 董感恩
 * @date 2020-07-07 22:15
 * @desc
 */
public class LogFly implements Flyable{

    private Flyable flyable;

    LogFly(Flyable flyable){
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("开始记录日志");
        flyable.fly();
        System.out.println("结束记录日志");
    }
}
