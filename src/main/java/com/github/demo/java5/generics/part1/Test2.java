package com.github.demo.java5.generics.part1;

import java.util.Arrays;
import java.util.List;

/**
 * 固定上边界的通配符
 */
public class Test2 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 6);
        List<Double> doubles = Arrays.asList(1.0, 2.3, 7.7, 8.9);

        double v = sumOfList(integers);
        double v1 = sumOfList(doubles);

        System.out.println(v);
        System.out.println(v1);
    }

    public static double sumOfList(List<? extends Number> list){
        double d = 0.0;
        for (Number n:list) {
            d += n.doubleValue();
        }
        return d;
    }
}


