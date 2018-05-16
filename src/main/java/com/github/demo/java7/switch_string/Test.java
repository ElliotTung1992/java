package com.github.demo.java7.switch_string;

public class Test {

    public static void main(String[] args) {
        String color = "black";
        switch (color){
            case "red":
                System.out.println("红色");
                break;
            case "yellow":
                System.out.println("黄色");
                break;
            case "blue":
                System.out.println("蓝色");
                break;
            case "black":
                System.out.println("黑色");
                break;
            default:
                System.out.println("不知道");
        }
    }
}
