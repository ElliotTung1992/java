package com.github.demo.java8.default_method;

/**
 * 默认方法熟悉
 */
public class Test1 {

    public static void main(String[] args) {
        B b = new B();
        b.hello();
    }
}

interface A{
    default void hello(){
        System.out.println("A.hello()");
    }
}

class B implements A{

}
