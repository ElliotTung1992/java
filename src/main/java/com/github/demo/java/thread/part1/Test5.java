package com.github.demo.java.thread.part1;

public class Test5 {


    public static void main(String[] args) {
        Test5 test5 = new Test5();
        MyThread myThread = test5.new MyThread();
        myThread.start();
    }

    class MyThread extends Thread{

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            for (int j = 0; j < 50000000; j++) {
//                Thread.yield();
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }
}
