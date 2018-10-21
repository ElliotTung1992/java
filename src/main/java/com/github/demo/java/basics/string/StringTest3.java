package com.github.demo.java.basics.string;

public class StringTest3 {

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "ABCD";
        String s3 = new String("ABCD");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
    }
}
