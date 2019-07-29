package com.github.demo.java8.stream;

import java.util.stream.IntStream;

/**
 * 传统 for 循环的函数式替代方案
 */
public class Java8Test3 {

    public static void main(String[] args) {

        //for 循环的麻烦
        test1();

        //可变变量与参数
//        test2();

        //封闭范围
//        test3();

        //跳过值
//        test4();

        //逆向迭代
//        test5();
    }

    private static void test5() {
        for (int i = 7; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("==============");
        IntStream.iterate(7, e -> e - 1)
                .limit(7)
                .forEach(System.out::println);
    }

    private static void test4() {
        int sum = 0;
        for (int i = 0; i <= 100; i = i + 3) {
            sum += i;
        }
        System.out.println(sum);

        int sum1 = IntStream.iterate(0, e -> e + 3)
                .limit(34)
                .sum();
        System.out.println(sum1);
    }

    private static void test3() {
        for (int i = 0; i <= 5 ; i++) {
            System.out.println(i);
        }

        System.out.println("=========");

        IntStream.rangeClosed(0, 5)
                .forEach(System.out::println);
    }

    private static void test2() {
        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(temp);
                }
            }).start();
        }

        IntStream.range(0, 5).forEach(e -> {
            new Thread(() -> {
                System.out.println(e);
            }).start();
        });
    }

    private static void test1() {
        //for循环打印区间
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        //java8打印区间
        IntStream.range(0, 4).forEach(System.out::println);
    }
}
