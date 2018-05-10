package com.github.demo.java.thread.part4;

public class InterruptTest4 {

    public static void main(String[] args) {
        Thread4 thread = new Thread4();
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}

class Thread4 extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(isInterrupted());
        }
    }
}

