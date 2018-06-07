package com.github.demo.java8.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8内置的四大核心函数式接口
 */
public class Test1 {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }



    //predicate<T> 断言型接口
    private static void test6() {
        List<String> strings = Arrays.asList("dong", "lion", "fen", "yan");
        Predicate<String> predicate = s -> s.contains("o");
        for (String s:strings) {
            if(predicate.test(s)){
                System.out.println(s);
            }
        }
    }

    //================================================

    //Function<T,R>函数型接口
    private static void test4() {
        Function<String, String> function = s -> s.toUpperCase();
        String str = function.apply("abc");
        System.out.println(str);
    }

    private static void test5() {
        Function<Integer, Integer> function = a -> addOne(a);
        Integer a = function.apply(10);
        System.out.println(a);
    }

    private static int addOne(int num){
        return num + 1;
    }


    //========================================================

    //Supplier<T>供给型接口
    private static void test2() {
        Supplier<Integer> supplier = () -> (int)(Math.random() * 100);
        for (int i = 0; i < 10; i++) {
            Integer integer = supplier.get();
            System.out.println(integer);
        }
    }

    private static void test3() {
        int a = 10;
        Supplier<Integer> sup = () -> 10;

        a = add(a, sup);
        System.out.println(a);
    }

    private static Integer add(int a, Supplier<Integer> sup) {
        return a + sup.get();
    }

    //========================================================

    //Consumer<T> 消费型接口
    private static void test1() {
        String str = "hello java8";
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept(str);
    }
}
