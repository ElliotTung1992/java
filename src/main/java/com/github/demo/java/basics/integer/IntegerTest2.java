package com.github.demo.java.basics.integer;

public class IntegerTest2 {

    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        //值传递
        swap(x, y);
        System.out.println(x);
        System.out.println(y);

        Value value = new Value(5, 10);
        swap(value);
        System.out.println(value.x);
        System.out.println(value.y);
    }

    private static void swap(Value value) {
        int temp = value.x;
        value.x = value.y;
        value.y = temp;
    }

    private static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
}

