package com.github.demo.java8.stream;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Java 知道您的类型
 */
public class Java8Test8 {

    public static void main(String[] args) {
        //显式类型和冗余
        test1();
        //Java 8 中的类型推断
        test2();
        //信任编译器
        test3();
        //类型推断和可读性
        test4();
        //推断的局限性
        test5();
    }

    private static void test5() {
        createComparator();
        createComparator1();
    }

    private static Comparator<Car> createComparator1() {
        //reversed的返回值是Comparator<T>
        //return Comparator.comparing(car -> car.getYear()).reversed();
        //方法引用补救
        return Comparator.comparing(Car::getYear).reversed();
    }

    private static Comparator<Car> createComparator() {
        return Comparator.comparing(car -> car.getYear());
    }


    private static void test4() {
        /*List<String> result =
                cars.stream()
                        .map((Car c) -> c.getRegistration())
                        .map((String s) -> DMVRecords.getOwner(s))
                        .map((Person o) -> o.getName())
                        .map((String s) -> s.toUpperCase())
                        .collect(toList());*/
        //可读性命名
        /*List<String> result =
                cars.stream()
                        .map((Car car) -> car.getRegistration())
                        .map((String registration) -> DMVRecords.getOwner(registration))
                        .map((Person owner) -> owner.getName())
                        .map((String name) -> name.toUpperCase())
                        .collect(toList());*/

        //上下文类型自动推断
        /*List<String> result =
                cars.stream()
                        .map(car -> car.getRegistration())
                        .map(registration -> DMVRecords.getOwner(registration))
                        .map(owner -> owner.getName())
                        .map(name -> name.toUpperCase())
                        .collect(toList());*/
    }

    private static void test3() {
        /*IntStream.rangeClosed(1, 5)
                .forEach((number) -> System.out.println(number.length() * 2));*/
    }

    private static void test2() {
        IntStream.rangeClosed(1, 5)
                .forEach(i -> System.out.println(i * 2));
    }

    private static void test1() {
        IntStream.rangeClosed(1, 5)
                .forEach((int i) -> System.out.println(i * 2));
    }
}

