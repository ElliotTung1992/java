package com.github.demo.java.basics.integer;

public class IntegerTest3 {

    public static void main(String[] args) {
        Value value = new Value(5, 10);
        swap(value);
        System.out.println(value.x);
        System.out.println(value.y);
    }

    private static void swap(Value value) {
        /*int temp = value.x + value.y;
        value.x = temp - value.y;
        value.y = temp - value.x;*/
        value.x = value.x + value.y;
        value.y = value.x - value.y;
        value.x = value.x - value.y;
    }
}
