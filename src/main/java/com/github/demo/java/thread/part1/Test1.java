package com.github.demo.java.thread.part1;

public class Test1{

    public static void main(String[] args) {
        System.out.println("主线程ID: " + Thread.currentThread().getId());
//
//
//        MyThread myThread2 = new MyThread("Thread2");
//        myThread2.start();
//
//        MyThread myThread = new MyThread("Thread1");
//        myThread.run();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类:" + Thread.currentThread().getId());
            }
        }).start();

        new Thread(() -> {
            System.out.println("lambda:" + Thread.currentThread().getId());
        }).start();
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("子线程:" + Thread.currentThread().getId());
    }
}

class MyThread extends Thread{

    private String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:" + name + " 子线程ID: " + Thread.currentThread().getId());
    }
}
