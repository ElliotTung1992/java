package com.github.demo.java8.method_reference;

import java.util.Arrays;

/**
 * 方法引用小案例：
 *
 * 方法引用和传统方式比较
 */
public class Test1 {

    public static void main(String[] args) {
        String[] strArr = {"g", "e", "x", "a", "p"};

        //传统方式
//        test1(strArr);

        //方法引用
        test2(strArr);
    }

    private static void test2(String[] strArr) {
        Arrays.sort(strArr, String::compareToIgnoreCase);

        for (String str:strArr) {
            System.out.println(str);
        }
    }

    private static void test1(String[] strArr) {
        Arrays.sort(strArr, (s1, s2)->s1.compareToIgnoreCase(s2));

        for (String str:strArr) {
            System.out.println(str);
        }
    }

}
