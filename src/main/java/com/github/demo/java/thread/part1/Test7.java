package com.github.demo.java.thread.part1;

public class Test7 extends Thread{

    public Test7(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++) {
            System.out.println(getName() + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Test7("new Thread").start();

//        Thread.sleep(1000);

        for (int i = 0; i < 10 ; i++) {
            if(i == 5){
                Test7 test7 = new Test7("join");
                test7.start();
//                test7.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
