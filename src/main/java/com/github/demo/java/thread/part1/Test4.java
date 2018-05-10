package com.github.demo.java.thread.part1;

public class Test4 {

    int i = 0;
    Object object = new Object();

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        MyThread myThread1 = test4.new MyThread();
        MyThread myThread2 = test4.new MyThread();

        myThread1.start();
        myThread2.start();
    }

    class MyThread extends Thread{

        @Override
        public void run() {
            synchronized (object){
                i++;
                System.out.println("当前编号:" + i);
                try {
                    System.out.println(Thread.currentThread().getName() + "线程开始睡眠");
                    Thread.currentThread().sleep(10000);
                    System.out.println(Thread.currentThread().getName() + "线程结束睡眠");
                    i++;
                    System.out.println("当前编号:" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
