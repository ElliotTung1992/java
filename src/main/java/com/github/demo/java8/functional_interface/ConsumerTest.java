package com.github.demo.java8.functional_interface;

import com.github.demo.domain.User;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjDoubleConsumer;

/**
 * @Author 小眼睛带鱼
 * @Description
 * @Date 2019/8/1
 **/
public class ConsumerTest {

    public static void main(String[] args){
        //test1();
        //test2();
        //test3();
        //test4();
    }

    private static void test4() {
        ObjDoubleConsumer<String> doubleConsumer = (obj, doub)
                -> System.out.println(obj + doub);
        doubleConsumer.accept("金额：", 222.66);
    }

    private static void test3() {
        DoubleConsumer doubleConsumer = System.out::println;
        DoubleConsumer doubleConsumer2 = System.out::println;
        doubleConsumer.andThen(doubleConsumer2).accept(2.44);
    }

    private static void test2() {
        BiConsumer<String, String> biConsumer = (str1, str2) -> System.out.println(str1 + " " + str2);
        biConsumer.accept("hello", "world");

        testBiConsumer(biConsumer);
    }

    private static void testBiConsumer(BiConsumer<String, String> biConsumer) {
        biConsumer.accept("foo", " bar");
    }

    private static void test1() {
        StringBuilder sb = new StringBuilder("Hello ");
        Consumer<StringBuilder> consumer = (str) -> str.append("Jack");
        consumer.accept(sb);
        System.out.println(sb.toString());

        User user = new User(1, "王琦", 24);
        Consumer<Integer> consumer1 = age -> user.setAge(age);
        consumer1.accept(10);
        System.out.println(user.getAge());

        Consumer<User> consumer2 = u -> System.out.println("name: " + u.getName() + " age:" + u.getAge());
        consumer2.accept(user);

        Consumer<StringBuilder> consumer3 = str -> str.append(" Mike");
        consumer.andThen(consumer3).accept(sb);

        System.out.println(sb.toString());

        testConsumer(consumer);

        testConsumer2(User::getAge);
    }

    private static void testConsumer(Consumer<StringBuilder> consumer) {
        StringBuilder sb = new StringBuilder().append("hello ");
        consumer.accept(sb);
        System.out.println(sb.toString());
    }

    private static <T> void testConsumer2(Consumer<? extends T> consumer) {

    }
}
