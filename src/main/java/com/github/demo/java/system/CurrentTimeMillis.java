package com.github.demo.java.system;

import java.util.concurrent.CountDownLatch;

/**
 * @author 董感恩
 * @date 2020-04-07 20:52
 * @desc
 */
public class CurrentTimeMillis {

    private static final int COUNT = 100;

    public static void main(String[] args) throws InterruptedException {
        long beginTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            System.currentTimeMillis();
        }
        long elapsedTime = System.nanoTime() - beginTime;
        System.out.println("100 System.currentTimeMillis() serial calls: " + elapsedTime + " ns");

        CountDownLatch startLatcg = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(COUNT);

        for (int i = 0; i < COUNT; i++) {
            new Thread(() -> {
                try {
                    startLatcg.await();
                    System.currentTimeMillis();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    endLatch.countDown();
                }
            }).start();
        }
        beginTime = System.nanoTime();
        startLatcg.countDown();
        endLatch.await();
        elapsedTime = System.nanoTime() - beginTime;
        System.out.println("100 System.currentTimeMillis() serial calls: " + elapsedTime + " ns");
    }
}
