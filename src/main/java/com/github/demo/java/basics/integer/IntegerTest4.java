package com.github.demo.java.basics.integer;

public class IntegerTest4 {

    public static void main(String[] args) {
        Value value = new Value(5, 10);
        swap(value);
        System.out.println(value.x);
        System.out.println(value.y);
    }

    private static void swap(Value value) {
        value.x = value.x ^ value.y;
        value.y = value.x ^ value.y;
        value.x = value.x ^ value.y;
    }
}
