package com.github.demo.java.basics.statictest;

public class BlockTest {

    {
        int a = 10;
        System.out.println(a);
    }

    {
        int b = 20;
        System.out.println(b);
    }

    public BlockTest(){
        System.out.println("构造函数执行");
    }

    public static void main(String[] args) {
        BlockTest blockTest = new BlockTest();
    }
}
