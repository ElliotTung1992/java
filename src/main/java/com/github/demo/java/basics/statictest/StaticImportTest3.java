package com.github.demo.java.basics.statictest;

import java.text.NumberFormat;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Math.PI;
import static java.text.NumberFormat.getInstance;

/**
 * 静态导入的正确使用姿势
 */
public class StaticImportTest3 {

    public static void main(String[] args) {
        double s = PI * parseDouble("20.3");
        NumberFormat instance = getInstance();
        instance.setMaximumFractionDigits(parseInt("222"));
    }
}
