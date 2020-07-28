package com.github.demo.designPattern.proxy.simple_demo;

import java.util.Random;

/**
 * @author 董感恩
 * @date 2020-07-07 22:03
 * @desc
 */
public class Bird implements Flyable{

    @Override
    public void fly() {
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("鸟儿飞啊飞...");
    }

    @Override
    public void fly2() {
        System.out.println("鸟儿飞啊飞2...");
    }
}
