package com.github.demo.java5.foreach;

import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        //1.5之前
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("--------");

        //foreach
        for (Integer i:list) {
            System.out.println(i);
        }

        System.out.println("-------------");

        Set<String> set = new HashSet<>();
        set.add("BWM");
        set.add("HM");
        set.add("APPLE");
        //1.5之前
        for (Iterator<String> i = set.iterator(); i.hasNext();){
            String next = i.next();
            System.out.println(next);
        }

        System.out.println("-------------");

        for (String s:set) {
            System.out.println(s);
        }
    }
}
