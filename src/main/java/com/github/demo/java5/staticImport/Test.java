package com.github.demo.java5.staticImport;

import static java.lang.System.out;

public class Test {

    public static void main(String[] args) {
        System.out.println("不使用静态导入");
        out.println("import static java.lang.System.out;");
    }
}
