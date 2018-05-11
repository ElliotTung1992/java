package com.github.demo.java5.threadPool.part2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                                                                new ArrayBlockingQueue<>(5));

        for (int i = 0; i < 20; i++) {
            MyTask myTask = new MyTask(i);
            threadPool.execute(myTask);
            System.out.println("线程池中线程数目："+threadPool.getPoolSize()+"，队列中等待执行的任务数目："+
                    threadPool.getQueue().size()+"，已执行玩别的任务数目："+threadPool.getCompletedTaskCount());
        }

        threadPool.shutdown();
    }
}

class MyTask implements Runnable{

    private int num;

    public MyTask(int num){
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task:" + num);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task:" + num + " 执行完毕");
    }
}
