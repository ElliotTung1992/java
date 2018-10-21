package com.github.demo.java.basics.string;

public class StringTest7 {

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        String s1 = new String();
        for (int i = 0; i < 1000000; i++) {
            s1 += i;
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        long start2 = System.currentTimeMillis();
        StringBuffer s2 = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            s2.append(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);

        long start3 = System.currentTimeMillis();
        StringBuilder s3 = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            s3.append(i);
        }
        long end3 = System.currentTimeMillis();
        System.out.println(end3 - start3);
    }
}
