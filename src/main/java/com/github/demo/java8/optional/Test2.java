package com.github.demo.java8.optional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 正确姿势使用Optional API
 */
public class Test2 {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test6();
//        test7();
//        test8();
        test9();
    }

    private static void test9() {
        User user = new User();
        user.setName("dong");
        User user2 = new User();
        Optional<User> user1 = Optional.ofNullable(user);
        Optional<User> user3 = Optional.ofNullable(user2);
        String s = user3.map(u -> u.getName())
                .map(name -> name.toUpperCase())
                .orElse(null);
        System.out.println(s);
    }

    private static void test8() {
        Order order = new Order("苹果");
        List<Order> list = new ArrayList<>();
        list.add(order);
        User user = new User();
        user.setOrders(list);

        Optional<User> user1 = Optional.ofNullable(user);

        User user2 = new User();
        Optional<User> user3 = Optional.ofNullable(user2);
        List<Order> orders = user3.map(u -> u.getOrders()).orElse(Collections.emptyList());
        System.out.println(orders.toString());
    }

    private static void test7() {
        Optional<Object> o = Optional.ofNullable(null);
        Object o1 = o.orElse(100);
        System.out.println(o1);
    }

    private static void test6() {
        Optional<Integer> integer = Optional.ofNullable(13);
    }

    private static void test4() {
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.orElseGet(() -> test5()));

    }

    private static Object test5() {
        return 12;
    }

    private static void test3() {
        Optional<Integer> integer = Optional.of(null);
        Integer integer1 = integer.get();
        System.out.println(integer1);
    }

    private static void test2() {
        Optional.of(null);
    }

    private static void test1() {
        //返回空的 Optional 实例。
        Optional<Object> empty = Optional.empty();

        //判断是否为Optional对象，不是返回false,是继续判断值是否相同，相同返回true
        boolean equals = empty.equals(Optional.empty());
        System.out.println(equals);

        Optional<Integer> integer = Optional.of(10);
        boolean equals1 = integer.equals(Optional.of(11));
        System.out.println(equals1);
    }
}

class User{

    private List<Order> orders;
    private String name;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Order{
    private String name;

    public Order(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                '}';
    }
}
