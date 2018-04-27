package com.github.demo.java5.generics.part1;

import java.util.ArrayList;
import java.util.List;

/**
 * 固定下边界通配符使用
 */
public class Test3 {

    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();
        addIntegerToList(objectList);

        List<Number> numberList = new ArrayList<>();
        addIntegerToList(numberList);

        List<Double> doubleList = new ArrayList<>();
//        addIntegerToList(doubleList);
    }

    /**
     * <? super Integer>
     * Object和Number是Integer的父类，
     * 我们可以向Object和Number类型的集合添加Integer类型
     * Double类型不是Integer的父类，所以不可以
     * @param list
     */
    public static void addIntegerToList(List<? super Integer> list){
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    /**
     * <? super Integer>
     * list返回的类型在Integer和Object之间
     * 所以返回的对象类型无法确定，但是一定可用Onject接收
     * @param list
     */
    public static void getFromList(List<? super Integer> list){
//        Integer i = list.get(0);
        Object o = list.get(0);
    }
}
