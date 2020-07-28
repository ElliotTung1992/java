package com.github.demo.designPattern.proxy.simple_demo;

/**
 * @author 董感恩
 * @date 2020-07-07 22:10
 * @desc
 */
public class TimeFly implements Flyable{

    private Flyable flyable;

    TimeFly(Flyable flyable){
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        flyable.fly();
        System.out.println("总共消耗:" + (System.currentTimeMillis() - start));
    }

    @Override
    public void fly2() {

    }
}
