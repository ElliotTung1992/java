package com.github.demo.java8.functional_interface;

import java.util.function.*;

/**
 * @Author 小眼睛带鱼
 * @Description
 * @Date 2019/8/2
 **/
public class FunctionTest {

    public static void main(String[] args){
        //test1();
        //test2();
        //test3();
        test4();
    }

    private static void test4() {
        DoubleToIntFunction doubleToIntFunction = d -> Double.valueOf(d).intValue();
        System.out.println(doubleToIntFunction.applyAsInt(10.99));
    }

    private static void test3() {
        DoubleFunction<Double> doubleDoubleFunction = d -> d += 10.00;
        System.out.println(doubleDoubleFunction.apply(3.2));
    }

    private static void test2() {
        BiFunction<String, String, String> biFunction = (a, b) -> a + " " + b;
        System.out.println(biFunction.apply("hello", "world"));
        biFunction = biFunction.andThen(a -> a + "!!!");
        System.out.println(biFunction.apply("hello", "world"));
    }

    private static void test1() {
        Function<String, String> function = s -> s += "!";
        System.out.println(function.apply("hello"));
        function = function.andThen(s -> s += "?");
        System.out.println(function.apply("hi"));
        function = function.compose(s -> s += "|");
        System.out.println(function.apply("Ok"));
    }

}
