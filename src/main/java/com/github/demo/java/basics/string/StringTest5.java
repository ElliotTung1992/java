package com.github.demo.java.basics.string;

public class StringTest5 {

    public static void main(String[] args) {
        String str1 = new String();
        for (int i = 0; i < 10; i++) {
            str1 = new StringBuilder().append(str1).append(i).toString();
        }
        System.out.println(str1);

        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            str2.append(i);
        }
        System.out.println(str2);
    }
}
