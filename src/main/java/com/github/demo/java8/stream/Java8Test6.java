package com.github.demo.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 为什么完美的 lambda 表达式只有一行
 */
public class Java8Test6 {

    public static void main(String[] args) {
        //lambda表达式示例
        test1();
        //多行lambda表达式
        test2();
        //函数组合的强大功能
//        test3();
        //充满危险的长 lambda 表达式
        test4();
        //使用 Lambda 作为粘合代码
        test5();
    }

    private static void test5() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = integerList.stream()
                .mapToInt(e -> sumOfFactors(e))
                .sum();
        System.out.println(sum);
    }

    private static int sumOfFactors(int number) {
        return IntStream.rangeClosed(1, number - 1)
                .filter(i -> number % i == 0)
                .sum();
    }

    private static void test4() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum1 = integerList.stream()
                .mapToInt(e -> {
                    int sum = 0;
                    for (int i = 1; i < e; i++) {
                        if (e % i == 0) {
                            sum += i;
                        }
                    }
                    return sum;
                }).sum();
        System.out.println(sum1);
    }

    private static void test3() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //命令式风格编写
        int result = 0;
        for (int i:
        integerList) {
            if(i > 3 && i % 2 == 0){
                result = i + 2;
                break;
            }
        }
        System.out.println(result);
        //函数式风格
        Integer integer = integerList.stream()
                .filter(e -> e > 3)
                .filter(e -> e % 2 == 0)
                .map(e -> e + 2)
                .findFirst()
                .orElse(0);
        System.out.println(integer);
    }

    private static void test2() {
        IntStream.range(1, 3)
                .map(e -> {
                    double sqrt = Math.sqrt(e);
                    double log = Math.log(e);
                    double aaa = sqrt + log;
                    return 1;
                });
    }

    private static void test1() {
        IntStream.range(1, 3)
                .map(e -> e * 2);
    }
}
