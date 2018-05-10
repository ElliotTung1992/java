package com.github.demo.java.thread.part1;

public class Test6 {

    public static void main(String[] args) {

        Test6 test6 = new Test6();
        MyThread myThread = test6.new MyThread();
        System.out.println("start:" + myThread.isAlive());
        myThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end:" + myThread.isAlive());
    }

    class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("run: " + this.isAlive());
        }
    }
}


