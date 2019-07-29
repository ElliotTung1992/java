package com.github.demo.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * 级联 lambda 表达式
 */
public class Java8Test9 {

    public static void main(String[] args) {
        //一个接收函数的函数
//        test1();
        //一个返回函数的函数
//        test2();
        //创建可重用的函数
//        test3();
        //创建和重用 lambda 表达式
//        test4();
        //保持简短的秘诀
        test5();
    }

    private static void test5() {
        Function<Integer, Predicate<Integer>> isGreaterThan = (Integer pivot) -> {
            Predicate<Integer> isGreaterThanPivot = (Integer candidate) -> {
                return candidate > pivot;
            };
            return isGreaterThanPivot;
        };

        //改进
        Function<Integer, Predicate<Integer>> isGreaterThan2 = pivot -> {
            Predicate<Integer> isGreaterThanPivot = candidate -> {
                return candidate > pivot;
            };
            return isGreaterThanPivot;
        };

        //删除多余的 ()，
        Function<Integer, Predicate<Integer>> isGreaterThan3 = pivot -> {
            return candidate -> {
                return candidate > pivot;
            };
        };

        Function<Integer, Predicate<Integer>> isGreaterThan4 = pivot -> {
            return candidate -> candidate > pivot;
        };

        Function<Integer, Predicate<Integer>> isGreaterThan5 =
                pivot -> candidate -> candidate > pivot;

        List<Integer> integerList = Arrays.asList(10, 20, 30, 40, 50, 60, 120);

        List<Integer> valuesOver25_ = integerList.stream()
                .filter(isGreaterThan5.apply(25))
                .collect(toList());

//        valuesOver25_.stream().forEach(System.out::println);

        List<Integer> valuesOver50_ = integerList.stream()
                .filter(isGreaterThan5.apply(50))
                .collect(toList());

//        valuesOver50_.stream().forEach(System.out::println);

        List<Integer> valuesOver75_ = integerList.stream()
                .filter(isGreaterThan5.apply(75))
                .collect(toList());

//        valuesOver75_.stream().forEach(System.out::println);
    }

    private static void test4() {
        List<Integer> integerList = Arrays.asList(10, 20, 30, 40, 50, 60, 120);
        List<Integer> valuesOver25 = integerList.stream()
                .filter(e -> e > 25)
                .collect(toList());

        List<Integer> valuesOver50 = integerList.stream()
                .filter(e -> e > 50)
                .collect(toList());

        List<Integer> valuesOver75 = integerList.stream()
                .filter(e -> e > 75)
                .collect(toList());

        Function<Integer, Predicate<Integer>> isGreaterThan = (Integer pivot) -> {
                Predicate<Integer> isGreaterThanPivot = (Integer candidate) -> {
                return candidate > pivot;
            };
            return isGreaterThanPivot;
        };

        List<Integer> valuesOver25_ = integerList.stream()
                .filter(isGreaterThan.apply(25))
                .collect(toList());

//        valuesOver25_.stream().forEach(System.out::println);

        List<Integer> valuesOver50_ = integerList.stream()
                .filter(isGreaterThan.apply(50))
                .collect(toList());

//        valuesOver50_.stream().forEach(System.out::println);

        List<Integer> valuesOver75_ = integerList.stream()
                .filter(isGreaterThan.apply(75))
                .collect(toList());

//        valuesOver75_.stream().forEach(System.out::println);

    }

    private static void test3() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream()
                .filter(e -> e > 3)
                .collect(toList());
        integerList.stream()
                .filter(e -> e > 3)
                .map(e -> e * 2)
                .collect(toList());

        //改进后
        Predicate<Integer> predicate = e -> e > 3;

        integerList.stream()
                .filter(predicate)
                .collect(toList());
        integerList.stream()
                .filter(predicate)
                .map(e -> e * 2)
                .collect(toList());
    }

    private static void test2() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        int i = totalSelectedValues(integerList, createIsOdd());
        System.out.println(i);

        System.out.println(createIsOdd().test(5));
        System.out.println(createIsOdd().test(8));
    }

    private static Predicate<Integer> createIsOdd(){
        /*Predicate<Integer> predicate = (Integer number) -> number % 2 == 0;
        return predicate;*/

        //优化
        return number -> number % 2 == 0;
    }

    private static void test1() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        int i = totalSelectedValues(integerList, e -> e % 2 == 0);
        System.out.println(i);
    }

    private static int totalSelectedValues(List<Integer> values, Predicate<Integer> selector){
        return values.stream()
                .filter(selector)
                .reduce(0, Integer::sum);
    }
}
