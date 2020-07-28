package com.github.demo.designPattern.proxy.static_proxy;

/**
 * @author 董感恩
 * @date 2020-07-24 16:55
 * @desc 静态代理
 *
 *  静态代理的两种实现方式：
 *  1. 继承
 *  2. 聚合
 *
 *  静态代理的劣势
 *  1. 同样的逻辑代理多个类时，需要重复写
 *  2. 对同一个接口的多个方法都需要代理时，需要重复写
 */
public class StaticProxy {

    public static void main(String[] args) {
        //1.最简单的案例
        testOne();
        System.out.println("----------");
        //2.需要记录日志
        //2.1 使用继承实现
        testTwo();
        System.out.println("----------");
        //2.2 使用聚合
        testThree();
        System.out.println("----------");
        //3.聚合的好处
        testFour();
        testFive();
        System.out.println("----------");
    }

    private static void testFive() {
        //先记录日志再计时
        Cat cat = new Cat();
        LogRunnable logRunnable = new LogRunnable(cat);
        TimeRunnable timeRunnable = new TimeRunnable(logRunnable);
        timeRunnable.run();
    }

    private static void testFour() {
        //先计时再记录日志
        Cat cat = new Cat();
        TimeRunnable timeRunnable = new TimeRunnable(cat);
        LogRunnable logRunnable = new LogRunnable(timeRunnable);
        logRunnable.run();
    }

    private static void testThree() {
        LogRunnable logRunnable = new LogRunnable(new Cat());
        logRunnable.run();
    }

    private static void testTwo() {
        CatExtend catExtend = new CatExtend();
        catExtend.run();
    }

    private static void testOne() {
        Cat cat = new Cat();
        cat.run();
    }
}
