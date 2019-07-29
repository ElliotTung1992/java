package com.github.demo.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 传递表达式（pass-through lambdas）的替代方案
 */
public class Java8Test5 {

    public static void main(String[] args) {
        //什么是传递lambda表达式
//        test1();

        //lambda表达式和方法引用比较
        test2();
    }

    private static void test2() {
        List<String> names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");

        //lambda表达式
        List<String> collect = names.stream()
                .filter(name -> Objects.nonNull(name))
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());

        //方法引用
        List<String> collect1 = names.stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    private static void test1() {
        /**
         * e -> System.out.println(e) 是传递lambda表达式
         * 如果该 lambda 表达式没有对该形参执行任何实际操作，则付出的努力就白费了。
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(e -> e % 2 == 0)
                .forEach(e -> System.out.println(e));

        //使用方法引用
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);
    }
}
