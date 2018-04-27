package com.github.demo.java5.generics.part1;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符
 */
public class Wildcard {

    public static void main(String[] args) {
        /**
         * 1. 无边界的通配符(Unbounded Wildcards), 就是<?>, 比如List<?>.
           无边界的通配符的主要作用就是让泛型能够接受未知类型的数据.
         */
        test1();
    }

    public static void test1(){
        List<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("y");
        strList.add("c");
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        printList(strList);
        printList(intList);

        //数组

        Apple[] apples = new Apple[]{};
        Fruits[] fruits = new Fruits[]{};
        testArr(apples);

        List<Fruits> fruitsList = new ArrayList<>();
        List<Apple> appleList = new ArrayList<>();
//        testList(appleList);


    }

    public static void testArr(Fruits[] fruits){

    }

    public static void testList(List<Fruits> fruitsList){

    }

    /**
     * 我们不能对List<?>使用add方法, 仅有一个例外, 就是add(null). 为什么呢?
     * 因为我们不确定该List的类型, 不知道add什么类型的数据才对,
     * 只有null是所有引用数据类型都具有的元素. 请看下面代码:
     * @param list
     */
    public static void printList(List<?> list){
        for (Object o:list) {
            System.out.println(o);
        }
    }

    /**
     * 虽然Object类是所有类的父类,
     * 但是List<Object>跟其他泛型的List如List<String>,
     * List<Integer>不存在继承关系, 因此会报错.
     * @param list
     */
    public static void printList1(List<Object> list){
        for (Object o:list) {
            System.out.println(o);
        }
    }
}

class Fruits{

}

class Apple extends Fruits{

}

class Banana extends Fruits{

}




