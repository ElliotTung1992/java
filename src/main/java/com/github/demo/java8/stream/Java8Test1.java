package com.github.demo.java8.stream;

import java.util.*;

/**
 * Java 中的一种更轻松的函数式编程途径
 */
public class Java8Test1 {

    public static void main(String[] args) {
        //命令式格式
//        test1();

        //声明式格式
//        test2();

        //函数式编程
//        test3();

        sort();
    }

    private static void sort() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(3);
        list.add(33);
        list.add(24);

        list.stream().sorted(Comparator.reverseOrder()).forEach(e -> {
            System.out.println(e);
        });

        list.stream().sorted().forEach(e -> {
            System.out.println(e);
        });
    }

    private static void test3() {
        Map<String, Integer> map = new HashMap<>();
        String key = "dong";
        map.merge(key, 1, (oldValue, value) -> oldValue + value);
        map.merge(key, 2, (oldValue, value) -> oldValue + value);

        System.out.println(map.get(key));

        Map<String , Integer> map1 = new HashMap<>();
        String key1 = "feng";
        if(map1.get(key1) == null){
            map1.put(key1, 1);
        }else{
            map1.put(key1, map1.get(key1) + 1);
        }

        if(map1.get(key1) == null){
            map1.put(key1, 1);
        }else{
            map1.put(key1, map1.get(key1) + 1);
        }

        System.out.println(map1.get(key1));
    }

    private static void test2() {
        List<String> names =
                Arrays.asList("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");

        if(names.contains("Nemo")){
            System.out.println("find Nemo");
        }else{
            System.out.println("do not find Nemo");
        }
    }

    private static void test1() {
        List<String> names =
                Arrays.asList("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");

        boolean isFound = false;

        for (String str:names) {
            if(str.equals("Nemo")){
                isFound = true;
            }
        }

        if(isFound){
            System.out.println("find Nemo");
        }else{
            System.out.println("do not find Nemo");
        }
    }
}
