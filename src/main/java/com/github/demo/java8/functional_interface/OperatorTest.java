package com.github.demo.java8.functional_interface;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @Author 小眼睛带鱼
 * @Description
 * @Date 2019/8/2
 **/
public class OperatorTest {

    public static void main(String[] args){
        //test1();
        //test2();
        test3();
    }

    private static void test3() {
        DoubleBinaryOperator doubleBinaryOperator = (doub1, doub2) -> doub1
                + doub2;
        System.out.println(doubleBinaryOperator.applyAsDouble(1.1, 2.3));
    }

    private static void test2() {
        BinaryOperator<String> binaryOperator = (str1, str2) -> str1 + str2;
        System.out.println(binaryOperator.apply("hello ", "张鹏"));
        Function<String, String> function = a -> a + "!!!";
        System.out.println(binaryOperator.andThen(function).apply("hello ", "齐振鑫"));
    }

    private static void test1() {
        UnaryOperator<String> unaryOperator = s -> s + " hello ";
//        System.out.println(unaryOperator.apply("Mike"));
        UnaryOperator<String> unaryOperator1 = t -> t + " How are you";
//        String str = unaryOperator.andThen(unaryOperator1).apply("王琦");
//        System.out.println(str);
        String apply = unaryOperator.compose(unaryOperator1).apply("姚鲍峰");
        System.out.println(apply);
    }

}
