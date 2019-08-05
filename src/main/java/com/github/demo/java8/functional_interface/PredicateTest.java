package com.github.demo.java8.functional_interface;

import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

/**
 * @Author 小眼睛带鱼
 * @Description
 * @Date 2019/8/2
 **/
public class PredicateTest {

    public static void main(String[] args){
        //test1();
        //test2();
        test3();
    }

    private static void test3() {
        DoublePredicate doublePredicate = d -> d != 10.0;
        System.out.println(doublePredicate.test(10.0));
        System.out.println(doublePredicate.test(12.0));
    }

    private static void test2() {
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a != b;
        System.out.println(biPredicate.test(10, 5));
        System.out.println(biPredicate.test(5, 5));
        biPredicate = biPredicate.and((a, b) -> a > b);
        System.out.println(biPredicate.test(10, 5));
        System.out.println(biPredicate.test(3, 5));
        biPredicate = biPredicate.or((a, b) -> a+b > 20);
        System.out.println(biPredicate.test(20, 10));
        System.out.println(biPredicate.test(5, 10));
        biPredicate = biPredicate.negate();
        System.out.println(biPredicate.test(20, 10));
        System.out.println(biPredicate.test(5, 10));
    }

    private static void test1() {
        Predicate<Integer> predicate = i -> i != 0;
        System.out.println(predicate.test(10));
        System.out.println(predicate.test(0));
        predicate = predicate.and(j -> j > 5);
        System.out.println(predicate.test(3));
        System.out.println(predicate.test(6));
        predicate = predicate.or(i -> i != 3);
        System.out.println(predicate.test(3));
        System.out.println(predicate.test(4));
        //将判断的结果取反
        predicate = predicate.negate();
        System.out.println(predicate.test(3));
        System.out.println(predicate.test(4));
    }
}
