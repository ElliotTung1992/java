package com.github.demo.java.thread.part1;

public class Test8 {

    public static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始运行");

        Test8 test8 = new Test8();
        Thread8 thread8 = test8.new Thread8();
        thread8.start();
        thread8.join();

        i++;
        System.out.println(i);
        System.out.println("主线程结束运行");
    }

    class Thread8 extends Thread{

        @Override
        public void run() {
            i = i + 10;
        }
    }
}


