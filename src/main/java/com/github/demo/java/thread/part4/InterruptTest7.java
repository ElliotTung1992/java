package com.github.demo.java.thread.part4;

public class InterruptTest7 {

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    private static void test() throws InterruptedException {
        MyThread thread = new MyThread();
        thread.interrupt();
        System.out.println(thread.isInterrupted());

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }

    static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("run");
        }
    }
}
