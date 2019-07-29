package com.github.demo.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 提倡使用有帮助的编码
 */
public class Java8Test4 {

    public static void main(String[] args) {

        //比较命令式和函数式两种写法理解需所花的时间
//        test1();

        //编写可读的代码
//        test2();

        //不要犯这样的错误
        test3();
    }

    private static void test3() {
        List<String> names = Arrays.asList("aaa", "bbb");

        //代码生硬不够简洁
        System.out.println(names.stream().filter(name -> name.startsWith("J")).filter(name -> name.length() > 3)
                .map(name -> name.toUpperCase()).collect(Collectors.joining(", ")));

        //正确的写法
        System.out.println(
                names.stream()
                        .filter(name -> name.startsWith("J"))
                        .filter(name -> name.length() > 3)
                        .map(name -> name.toUpperCase())
                        .collect(Collectors.joining(", ")));

    }

    private static void test2() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int result = 0;
        for (Integer i:
        integers) {
            if(i > 3 && i % 2 == 0 && i < 8){
                result += i;
            }
        }
        System.out.println(result);

        //可读性强
        int sum = integers.stream()
                .filter(e -> e > 3)
                .filter(e -> e % 2 == 0)
                .filter(e -> e < 8)
                .mapToInt(Integer::new)
                .sum();
        System.out.println(sum);
    }

    private static void test1() {
        //命令式
        List<String> names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");

        List<String> subList = new ArrayList<>();
        for(String name : names) {
            if(name.length() == 4)
                subList.add(name);
        }

        StringBuilder namesOfLength4 = new StringBuilder();
        for(int i = 0; i < subList.size() - 1; i++) {
            namesOfLength4.append(subList.get(i));
            namesOfLength4.append(", ");
        }

        if(subList.size() > 1)
            namesOfLength4.append(subList.get(subList.size() - 1));

        System.out.println(namesOfLength4);

        System.out.println(names.stream()
                                .filter(e -> e.length() == 4)
                                .collect(Collectors.joining(", ")));
    }
}
