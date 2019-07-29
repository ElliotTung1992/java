package com.github.demo.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 使用闭包捕获状态
 */
public class Java8Test10 {

    public static void main(String[] args) {
        //无状态的生活
        test1();
        //我们为什么需要状态
        test2();
        //词法范围
//        test3();
        //lambda 表达式中的词法范围
//        test4();
        //闭包如何携带状态
//        test5();
        //使用闭包
        test6();
    }

    private static void test6() {
        int factor = 4;//状态
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> collect = integerList.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * factor)
                .collect(Collectors.toList());
        collect.stream()
                .forEach(System.out::println);
    }

    private static void test5() {
        String message = "world";
        call(() -> System.out.println("hello " +message));
    }

    private static void call(Runnable runnable){
        runnable.run();
    }

    private static void test4() {
        String message = "world";
        Runnable runnable = () -> System.out.println("hello " + message);
        runnable.run();
    }

    private static void test3() {
        String message = "world";
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello " + message);
            }
        };
        runnable.run();
    }

    private static void test2() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int factor = 4;//状态
        integerList.stream()
                .filter(e -> e % 2 == 0)
                //.map((e, factor) -> e * factor)
                .collect(Collectors.toList());
    }

    private static void test1() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        integerList.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(Collectors.toList());

    }
}
