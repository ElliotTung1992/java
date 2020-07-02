package com.github.demo.java5.varargs.part1;

public class Test3 {

    public static void main(String[] args) {
        m1("");
        m1("aaa");
        m1("aaa", "bbb");
    }

    public static void m1(String s, String... ss) {
        int aaa = "aaa,bbb,ccc".indexOf("bbb");
        System.out.println(aaa);
    }
}
