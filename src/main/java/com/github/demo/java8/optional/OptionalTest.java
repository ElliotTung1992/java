package com.github.demo.java8.optional;

import com.github.demo.domain.User;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author 小眼睛带鱼
 * @date 2019-12-10 19:35
 * @desc
 */
public class OptionalTest {

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
        //test7();
        //test8();
        //test9();
        //test10();
        //test11();
        test12();
    }

    /**
     *
     * @author 小眼睛带鱼
     * @date 2019-12-11 13:30:12
     * @desc orElseThrow()Api
     **/
    private static void test12() {
        /*Integer age = null;
        Optional<Integer> optional = Optional.ofNullable(age);
        Integer integer = optional.orElseThrow();
        System.out.println(integer);*/
    }

    /**
     *
     * @author 小眼睛带鱼
     * @date 2019-12-11 13:30:12
     * @desc ifPresentOrElse()Api
     **/
    private static void test11() {
        Integer age = 11;
        Optional<Integer> optional = Optional.ofNullable(age);
        //optional.ifPresentOrElse(e -> System.out.println(e), () -> System.out.println("这是一个空值！！"));
    }

    /**
     *
     * @author 小眼睛带鱼
     * @date 2019-12-11 13:30:12
     * @desc or()Api
     **/
    private static void test10() {
//        Optional<Integer> optional = Optional.of(null);
//        Optional<Integer> optional = Optional.empty();
//        Optional<Integer> optional = Optional.of(12);
//        Optional<Integer> or = optional.or(() -> Optional.of(100));
//        System.out.println(or.get());
    }

    /**
     *
     * @author 小眼睛带鱼
     * @date 2019-12-11 13:30:12
     * @desc filter()Api
     **/
    private static void test9() {
        Integer age = 11;
        Optional<Integer> optional = Optional.ofNullable(age);
        Integer integer = optional.filter(e -> e > 10).map(e -> e + 2).orElse(10);
        System.out.println(integer);
    }

    /**
     *
     * @author 小眼睛带鱼
     * @date 2019-12-11 13:30:12
     * @desc map()Api
     **/
    private static void test8() {
//        com.github.demo.domain.User user = new com.github.demo.domain.User(1, "dge", 12);
        com.github.demo.domain.User user = null;
        Optional<com.github.demo.domain.User> optional = Optional.ofNullable(user);
        String s = optional.map(e -> e.getName()).map(e -> e.toUpperCase()).orElse("fnn");
        System.out.println(s);
    }

    /**
     *
     * @author 小眼睛带鱼
     * @date 2019-12-11 13:30:12
     * @desc ifPresent()Api
     **/
    private static void test7() {
        AtomicInteger twoAge = new AtomicInteger();
        //正确的使用姿势
        Consumer<Integer> consumer = e -> twoAge.set(e << 2);
        Integer age = 7;
        Optional<Integer> optional = Optional.ofNullable(age);
        optional.ifPresent(consumer);
        System.out.println(twoAge.get());
    }

    /**
     *
     * @author 小眼睛带鱼
     * @date 2019-12-11 13:30:12
     * @desc orElseGet()Api
     **/
    private static void test6() {
        Supplier<Integer> supplier = () -> 12;
        Integer age = null;
        Optional<Integer> optional = Optional.ofNullable(age);
        System.out.println(optional.orElseGet(() -> getInteger()));
    }

    private static Integer getInteger(){
        return 12/9;
    }
    
    /**
     * 
     * @author 小眼睛带鱼
     * @date 2019-12-11 13:30:12
     * @desc empty()Api
     **/
    private static void test5() {
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.orElse(11));
    }

    /**
     *
     * @author 小眼睛带鱼
     * @date 2019-12-11 13:29:15
     * @desc 简单案例错误使用方式
     **/
    private static void test4() {
        //错误姿势
        Integer age = 11;
        Optional<Integer> optionalInteger = Optional.ofNullable(age);
        if(optionalInteger.isPresent()){
            System.out.println(optionalInteger.get());
        }else{
            System.out.println(0);
        }
    }

    /**
     *
     * @author 小眼睛带鱼
     * @date 2019-12-11 13:29:15
     * @desc 简单案例正确使用方式
     **/
    private static void test3() {
        //正确姿势
        Integer age = null;
        Optional<Integer> optionalInteger = Optional.ofNullable(age);
        System.out.println(optionalInteger.orElse(0));
    }

    /**
     * 
     * @author 小眼睛带鱼
     * @date 2019-12-11 13:29:15
     * @desc 简单案例正确使用方式
     **/
    private static void test2() {
        //正确姿势
        com.github.demo.domain.User user = null;
        Optional<com.github.demo.domain.User> optionalUser = Optional.ofNullable(user);
        //System.out.println(optionalUser.isPresent());
        com.github.demo.domain.User dge = optionalUser.orElse(new com.github.demo.domain.User(1, "dge", 12));
        System.out.println(dge);
    }

    /**
     * 
     * @author 小眼睛带鱼
     * @date 2019-12-11 13:28:59
     * @desc 简单使用
     **/
    private static void test1() {
        User user = null;
        Optional<User> optionalUser = Optional.of(user);
    }
}
