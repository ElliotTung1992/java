package com.github.demo.java5.enums.part4;

import java.util.*;

public class Part4 {

    public static void main(String[] args) {
        List<Clothes> list = new ArrayList<>();
        list.add(new Clothes("C001",Color.BLUE));
        list.add(new Clothes("C002",Color.YELLOW));
        list.add(new Clothes("C003",Color.RED));
        list.add(new Clothes("C004",Color.GREEN));
        list.add(new Clothes("C005",Color.BLUE));
        list.add(new Clothes("C006",Color.BLUE));
        list.add(new Clothes("C007",Color.RED));
        list.add(new Clothes("C008",Color.YELLOW));
        list.add(new Clothes("C009",Color.YELLOW));
        list.add(new Clothes("C010",Color.GREEN));

        //使用HashMap
        Map<Color, Integer> map = new HashMap<>();
        for (Clothes clothes:list) {
            Color color = clothes.color;
            Integer integer = map.get(color);
            if(integer != null){
                map.put(color, integer + 1);
            }else{
                map.put(color, 1);
            }
        }
        System.out.println(map.toString());

        Map<Color, Integer> enumMap = new EnumMap<Color, Integer>(Color.class);
        for (Clothes clothes:list) {
            Color color = clothes.color;
            Integer integer = enumMap.get(color);
            if(integer != null){
                enumMap.put(color, integer + 1);
            }else{
                enumMap.put(color, 1);
            }
        }
        System.out.println(enumMap.toString());

    }
}

class Clothes{

    String name;
    Color color;

    public Clothes(String name, Color color) {
        this.name = name;
        this.color = color;
    }
}

enum Color{
    RED,BLUE,YELLOW,GREEN;
}
