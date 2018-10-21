package com.github.demo.java.basics.statictest;

import static java.lang.Math.*;

/**
 * 静态导入示例
 */
public class StaticImportTest {

    public static void main(String[] args) {
        double a = Math.cos(Math.PI / 2);
        //静态导入
        double b = cos(PI / 2);
    }
}
