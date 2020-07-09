package com.github.demo.designPattern.proxy.simple_demo;

/**
 * @author 董感恩
 * @date 2020-07-07 22:08
 * @desc
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("案例一开始");
        Bird bird = new Bird();
        bird.fly();
        System.out.println("案例一结束");

        System.out.println("案例二开始");
        TimeFly timeFly = new TimeFly(bird);
        timeFly.fly();
        System.out.println("案例二结束");

        System.out.println("案例三开始");
        LogFly logFly = new LogFly(timeFly);
        logFly.fly();
        System.out.println("案例三结束");
    }
}
