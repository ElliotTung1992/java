package com.github.demo.java.thread.part4;

public class InterruptTest5 {

    public static void main(String[] args) {
        Thread5 thread5 = new Thread5();
        thread5.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread5.interrupt();
    }
}

class Thread5 extends Thread{

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(isInterrupted());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("a:" + isInterrupted());
    }
}
