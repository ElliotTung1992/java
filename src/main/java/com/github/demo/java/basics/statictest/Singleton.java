package com.github.demo.java.basics.statictest;

public class Singleton {
    private static Singleton ourInstance = null;

    public static Singleton getInstance() {
        if(ourInstance == null){
            ourInstance = new Singleton();
        }
        return ourInstance;
    }

    private Singleton() {
    }
}
