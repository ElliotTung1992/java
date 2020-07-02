package com.github.demo.java.system;

import java.util.concurrent.CountDownLatch;

/**
 * @author 董感恩
 * @date 2020-04-07 21:29
 * @desc
 */
public class CountDownLatchDemo {

    static final CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {

        long beginTime = System.nanoTime();

        new Thread(() -> {
            methodOne();
            latch.countDown();
        }).start();

        new Thread(() -> {
            methodTwo();
            latch.countDown();
        }).start();

        new Thread(() -> {
            methodThree();
            latch.countDown();
        }).start();

        latch.await();
        long endTime = System.nanoTime() - beginTime;
        System.out.println(endTime);

        /*long beginTime = System.nanoTime();
        methodOne();
        methodTwo();
        methodThree();
        long endTime = System.nanoTime() - beginTime;
        System.out.println(endTime);*/
    }

    public static void methodOne(){
        System.out.println("methodOne");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void methodTwo(){
        System.out.println("methodTwo");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void methodThree(){
        System.out.println("methodThree");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
