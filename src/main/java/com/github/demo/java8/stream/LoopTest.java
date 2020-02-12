package com.github.demo.java8.stream;

import com.github.demo.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.util.stream.Collectors.toList;

/**
 * @author 董感恩
 * @date 2019-12-26 09:23
 * @desc 循环测试
 */
public class LoopTest {

    private static List<String> strListOne = Arrays.asList("aaa", "bbb", "ccc");
    private static List<String> strListTwo = Arrays.asList("ccc", "bbb", "ddd");

    private static List<User> userListOne = Arrays.asList(new User(1, "dge", 23),
            new User(2, "fnn", 35));
    private static List<User> userListTwo = Arrays.asList(new User(2, "fnn", 35),
            new User(3, "fjx", 18));

    public static void main(String[] args) {
        //interList();
        //diffList();
        //unionList();

        //interPojoList();
        //diffPojoList();

        foreach();
    }

    //如何在循环中退出
    private static void foreach() {
//        strListOne.stream().forEach(e -> {
//            strListTwo.stream().forEach(f -> {
//                if(e.equals(f)){
//                    return;
//                }
//                System.out.println(e);
//                System.out.println(f);
//                System.out.println("=========");
//            });
//        });

        try {
            strListOne.stream().forEach(e -> {
                strListTwo.stream().forEach(f -> {
                    if(e.equals(f)){
                        throw new RuntimeException("我想退出");
                    }
                    System.out.println(e);
                    System.out.println(f);
                    System.out.println("=========");
                });
            });
        }catch (RuntimeException e){
            System.out.println("哈哈 我退出来了！！！");
        }
    }

    // 取对象集合差集
    private static void diffPojoList() {
        List<User> list = userListOne.stream().filter(e -> diffUserHelp(e, userListTwo)).collect(toList());
        list.stream().forEach(System.out::println);
    }

    public static boolean diffUserHelp(User user, List<User> userList){
        AtomicBoolean flag = new AtomicBoolean(true);
        userList.stream().forEach(e -> {
            if(user.getId() == e.getId() && user.getName().equals(e.getName()) && user.getAge() == e.getAge()){
                flag.set(false);
            }
        });
        return flag.get();
    }

    //取对象集合交集
    private static void interPojoList() {
        List<User> list = userListOne.stream().filter(e -> interUserHelp(e, userListTwo)).collect(toList());
        list.stream().forEach(System.out::println);
    }

    public static boolean interUserHelp(User user, List<User> userList){
        AtomicBoolean flag = new AtomicBoolean(false);
        userList.stream().forEach(e -> {
            if(user.getId() == e.getId() && user.getName().equals(e.getName()) && user.getAge() == e.getAge()){
                flag.set(true);
            }
        });
        return flag.get();
    }

    //取交集
    private static void unionList() {
        //取所有的交集
        List<String> listOne = strListOne.parallelStream().collect(toList());
        List<String> listTwo = strListTwo.parallelStream().collect(toList());
        listOne.addAll(listTwo);
        listOne.forEach(System.out::println);
        System.out.println("===============");
        //去重
        List<String> distinctList = listOne.stream().distinct().collect(toList());
        distinctList.stream().forEach(System.out::println);
    }

    //取差级
    private static void diffList() {
        List<String> diffList = strListOne.stream().filter(e -> !strListTwo.contains(e)).collect(toList());
        diffList.stream().forEach(i -> System.out.println(i));
    }

    //取交集
    private static void interList() {
        List<String> interList = strListOne.stream().filter(i -> strListTwo.contains(i)).collect(toList());
        interList.stream().forEach(e -> System.out.println(e));
    }
}
