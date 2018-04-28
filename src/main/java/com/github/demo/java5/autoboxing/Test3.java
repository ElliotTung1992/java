package com.github.demo.java5.autoboxing;

public class Test3 {

    public static void main(String[] args) {
        int i = 10;
        test(i);
        Integer integer = Integer.valueOf(i);
        test(integer);
    }

    public static void test(int i){
        System.out.println("test int");
    }

    public static void test(Integer i){
        System.out.println("test Integer");
    }
}


