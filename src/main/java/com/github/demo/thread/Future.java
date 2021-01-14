package com.github.demo.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 董感恩
 * @date 2020-08-08 09:47
 * @desc Future类解析
 */
public class Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testOne();
        //testTwo();
    }

    private static void testTwo() {
        System.out.println("aaa");
        new Thread(() -> {
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("bbb");
        }).start();
        System.out.println("ccc");
    }

    //Future类和Thread类的区别
    //传统的Runnable没有返回值
    //FutureTask的参数Callable有返回值
    private static void testOne() throws ExecutionException, InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("Thread运行线程!");
        });
        t.start();

        FutureTask<Object> futureTask = new FutureTask<>(() -> {
            Thread.sleep(1000l);
            System.out.println("futureTask运行线程！");
            return "哈哈";
        });
        System.out.println("嘻嘻");

        Thread t2 = new Thread(futureTask);
        t2.start();

        System.out.println(futureTask.get());
    }
}
