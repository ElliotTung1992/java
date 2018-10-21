package com.github.demo.java.basics.statictest;

import java.text.NumberFormat;

import static java.lang.Double.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;
import static java.text.NumberFormat.*;

/**
 * 静态导入时最好不要使用*通配符
 * StaticImportTest3正确使用方法
 */
public class StaticImportTest2 {

    public static void main(String[] args) {
        double s = PI * parseDouble("20.3");
        NumberFormat instance = getInstance();
        instance.setMaximumFractionDigits(parseInt("222"));
    }
}
