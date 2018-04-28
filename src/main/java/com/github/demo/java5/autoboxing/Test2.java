package com.github.demo.java5.autoboxing;

public class Test2 {

    public static void main(String[] args) {
        Integer sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 400000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        long start1 = System.currentTimeMillis();
        int sum2 = 0;
        for (int i = 0; i < 400000; i++) {
            sum2 += i;
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
    }


}
