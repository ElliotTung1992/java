package com.github.demo.java5.generics.part1;

/**
 * 泛型边界符
 */
public class Test1 {

    public static void main(String[] args) {
        String[] ints = {"b", "c", "d"};
        int i = countGreaterThan1(ints, "a");
        System.out.println(i);
    }

    /**
     * 因为除了short, int, double, long, float, byte, char等原始类型，
     * 其他的类并不一定能使用操作符>，所以编译器报错，那怎么解决这个问题呢？答案是使用边界符。
     */
    public static <T> int countGreaterThan(T[] arr, T elem){
        int count = 0;
//        for (T t:arr) {
//            if(t > elem){
//                count ++;
//            }
//        }
        return count;
    }

    /**
     * 做一个类似于下面这样的声明
     * 这样就等于告诉编译器类型参数T代表的都是实现了Comparable接口的类
     */
    public static <T extends Comparable<T>> int countGreaterThan1(T[] arr, T elem){
        int count = 0;
        for (T t:arr) {
            if(t.compareTo(elem) > 0){
                count ++;
            }
        }
        return count;
    }
}


