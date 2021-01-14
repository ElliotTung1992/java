package com.github.demo.java.basics.booleantest;

/**
 * @author dge
 * @version 1.0
 * @date 2020-12-15 16:23
 */
public class BooleanTest {

    public static void main(String[] args) {
        boolean b = false;

        if(Boolean.TRUE.equals(b)){
            System.out.println("haha");
        }

        if(Boolean.TRUE == b){
            System.out.println("hehe");
        }

        System.out.println("===========");

        boolean i = false;

        if(Boolean.TRUE.equals(i)){
            System.out.println("haha");
        }

        if(Boolean.TRUE == i){
            System.out.println("hehe");
        }
    }
}
