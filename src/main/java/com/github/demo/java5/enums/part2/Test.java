package com.github.demo.java5.enums.part2;

/**
 * 在switch中使用枚举时，无序使用枚举引用
 */
public class Test {

    public static void main(String[] args) {
        test(Colour.BLUE);
    }

    public static void test(Colour colour){
        switch (colour){
            case RED:
                System.out.println("红色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case YELLOW:
                System.out.println("黄色");
                break;
        }
    }
}

enum Colour{
    RED,BLUE,YELLOW;
}
