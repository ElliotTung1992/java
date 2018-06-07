package com.github.demo.java8.default_method;

/**
 * 默认方法 特殊情况演示
 */
public class Test2 {


}

interface C{
    default void hello(){
        System.out.println("C.hello()");
    }
}

interface D{
    default void hello(){
        System.out.println("C.hello()");
    }
}

class E implements C,D{

    @Override
    public void hello() {
        C.super.hello();
    }
}
