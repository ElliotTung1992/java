package com.github.demo.java.basics.string;

public class StringTest2 {

    public static void main(String[] args) {
        String s1 = "A";
        String s2 = "B";
        String s3 = "C";
        System.out.println(s1);
        s1 = s2;
        System.out.println(s1);
        s1 = s2 + s3;
        System.out.println(s1);
    }
}
