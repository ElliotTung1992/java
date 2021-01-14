package com.github.demo.thread;

import java.util.stream.IntStream;

/**
 * @author 董感恩
 * @date 2020-08-24 16:36
 * @desc
 */
public class ThreadLocalTest {

    static ThreadLocal<Object> threadLocal = ThreadLocal.withInitial(() -> Integer.valueOf(0));

    public static void main(String[] args) {
        //testOne();

        testTwo();
    }

    private static void testTwo() {
        threadLocal.set("name");
        threadLocal.set("name");
    }

    /**
     * @author 董感恩
     * @date 2020-08-24 16:55:33
     * @desc 验证ThreadLocal和各自线程绑定
     **/
    private static void testOne() {
        Thread[] threadArr = new Thread[5];
        IntStream.range(0, 5).forEach(e -> {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread() + "initialValue is " + threadLocal.get());
                threadLocal.set(e);
                System.out.println(Thread.currentThread() + "setValue is " + e);
                System.out.println(Thread.currentThread() + "getValue is " + threadLocal.get());
            });
            threadArr[e] = thread;
        });

        for (Thread t:threadArr) {
            t.start();
        }
    }
}
