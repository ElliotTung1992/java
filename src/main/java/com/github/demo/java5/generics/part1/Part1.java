package com.github.demo.java5.generics.part1;

public class Part1 {

    public static void main(String[] args) {
        new Box().setName("aaa");
        new BoxO().setName("bbb");
        new BoxO().setName(123);
        new BoxG<String>().setT("ccc");
        new BoxG<Integer>().setT(12);
    }
}

/**
 *
 */
class Box{
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class BoxO{
    private Object name;

    public void setName(Object name) {
        this.name = name;
    }

    public Object getName() {
        return name;
    }
}

class BoxG<T>{
    T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
