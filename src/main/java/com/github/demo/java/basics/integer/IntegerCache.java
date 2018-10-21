package com.github.demo.java.basics.integer;

/**
 * Integer缓存
 */
public class IntegerCache {

    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 5;
        System.out.println(a == b);

        Integer c = 500;
        Integer d = 500;
        System.out.println(c == d);

        Integer e = new Integer(5);
        Integer f = new Integer(5);
        System.out.println(e == f);
    }
}
