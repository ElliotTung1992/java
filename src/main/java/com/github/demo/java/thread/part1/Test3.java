package com.github.demo.java.thread.part1;

public class Test3 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}

