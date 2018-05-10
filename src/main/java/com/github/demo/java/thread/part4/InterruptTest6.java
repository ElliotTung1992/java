package com.github.demo.java.thread.part4;

public class InterruptTest6 {

    private static Object lock = new Object();//monitor
    private static class A extends Thread {
        @Override
        public void run() {
            //等待lock锁
            synchronized (lock) {
                //等待标志位被置为true
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("lol");
                }
            }
            System.out.println("exit");
        }
    }
    public static void test() throws InterruptedException {
        synchronized (lock) {//获取锁
            A a = new A();
            a.start();
            Thread.sleep(1000);
            //a在等待lock锁，interrupt 无法中断
            a.interrupt();
            //a线程加入当前线程，等待执行完毕
            a.join();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
