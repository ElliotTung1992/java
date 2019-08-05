package com.github.demo.java8.functional_interface;

import com.github.demo.domain.User;

import java.util.function.Function;

/**
 * @Author 小眼睛带鱼
 * @Description
 * @Date 2019/8/1
 **/
public class Test3 {

    public static void main(String[] args){
        function1();
        User user = new User(1, "Jack", 123);
        function2(t -> user.getAge());
    }

    private static void function1() {
        Function<String, String> function = a -> a + " Jack!";
        System.out.println(function.apply("hello"));
    }

    private static void function2(Function<Object, Object> function) {
        System.out.println(function.apply("随便填"));
    }
}
