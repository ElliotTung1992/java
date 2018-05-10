package com.github.demo.java.thread.part4;

public class InterruptTest3 {

    public static void main(String[] args) throws InterruptedException {
        Thread3 thread3 = new Thread3();
        thread3.start();
        Thread3.sleep(1000);
        thread3.interrupt();
    }
}

class Thread3 extends Thread{

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("do something");
        }
        System.out.println("interrupt");
    }
}
