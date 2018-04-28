package com.github.demo.java5.autoboxing;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);//自动装箱 int -> Integer
        int a = integerList.get(0);//自动拆箱  Integer -> int

        //jdk1.5之前  int -> Integer
        Integer integer = Integer.valueOf(1);

        //jdk1.5之前  Integer -> int
        int i = integer.intValue();

        //jdk1.5之后
        Integer ii = 5;//自动装箱
        int dd = ii;//自动拆箱
    }
}
