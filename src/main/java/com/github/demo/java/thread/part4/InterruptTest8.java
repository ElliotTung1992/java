package com.github.demo.java.thread.part4;

import java.io.IOException;

public class InterruptTest8 {

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(100);

        t.interrupt();
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    System.out.println("lol");
                    System.out.println(System.in.read());//wait input
                    System.out.println("lpl");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("exit");
        }
    }
}
