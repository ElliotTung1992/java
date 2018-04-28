package com.github.demo.java5.autoboxing;

public class Test4 {

    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        System.out.println("a == b = " + (a == b));

        Integer integer1 = 1;
        Integer integer2 = 1;
        System.out.println("integer1 == integer2 = " + (integer1 == integer2));

        int c = 1;
        Integer integer = 1;
        System.out.println("c == integer = " + (c == integer));

        Integer integer3 = new Integer(1);
        Integer integer4 = new Integer(1);
        System.out.println("integer3 == integer4 = " + (integer3 == integer4));
    }
}
