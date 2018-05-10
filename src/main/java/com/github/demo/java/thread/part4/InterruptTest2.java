package com.github.demo.java.thread.part4;

public class InterruptTest2 {

    public static void main(String[] args) {
        Thread2 thread = new Thread2(Thread.currentThread());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("join了一下");
            e.printStackTrace();
        }
        System.out.println("终于等到你");
    }
}

class Thread2 extends Thread{

    Thread parent;

    public Thread2(Thread parent){
        this.parent = parent;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("i am ok");
            long now = System.currentTimeMillis();
            while(System.currentTimeMillis()-now < 2000){

            }
            parent.interrupt();
        }
    }
}
