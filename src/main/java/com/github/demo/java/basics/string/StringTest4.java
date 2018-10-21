package com.github.demo.java.basics.string;

public class StringTest4 {

    public static void main(String[] args) {
        String a = "hello";
        String b = " world";
        String c = a + b;
        c = new StringBuilder().append(a).append(b).toString();
        System.out.println(c);
    }
}
