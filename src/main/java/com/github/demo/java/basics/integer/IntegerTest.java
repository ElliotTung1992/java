package com.github.demo.java.basics.integer;

public class IntegerTest {

    public static void main(String[] args) {
        int i = 2;
        int j = ++i + 20;
        /**
         * int temp = i;
         * i += 1;
         * j = i + 20;
         */
        System.out.println(j + " " + i);

        int a = 2;
        int b = a++ + 20;
        /**
         * int temp = a;
         * a += 1;
         * b = temp + 20;
         */
        System.out.println(b + " " + a);
    }
}
