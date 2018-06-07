package com.github.demo.java8.optional;


import java.util.Optional;

/**
 * Optional API 熟悉
 */
public class Test1 {

    public static void main(String[] args) {
        Integer int1 = null;
        Integer int2 = 10;

        //Optional.ofNullable()允许int1的值为空
        Optional<Integer> a = Optional.ofNullable(int1);
        //Optional.of()如果传递的参数为null,则报NullPointerException
        Optional<Integer> b = Optional.of(int2);

        sum(a, b);
    }

    private static void sum(Optional<Integer> a, Optional<Integer> b) {
        //a.isPresent()判断值是否存在
        System.out.println(a.isPresent());
        System.out.println(b.isPresent());

        //a.orElse(0) 如果值存在则返回，否则返回默认值
        Integer integer1 = a.orElse(0);
        //b.get() 获取值，值必须存在
        Integer integer2 = b.get();

        System.out.println(integer1 + integer2);
    }
}
