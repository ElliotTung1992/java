package com.github.demo.java.basics.string;

public class StringTest6 {

    public static void main(String[] args) {
        String a = "name";
        String b = "dong";
        StringBuilder builder = new StringBuilder();
        builder.append(new StringBuilder().append(a).append(":").append(b));
    }
}
