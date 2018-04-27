package com.github.demo.java5.varargs.part1;

/**
 * 第一个能编译通过，这是为什么呢？事实上，base对象把子类对象sub做了向上转型，
 * 形参列表是由父类决定的，当然能通过。而看看子类直接调用的情况，
 * 这时编译器看到子类覆写了父类的print方法，因此肯定使用子类重新定义的print方法，
 * 尽管参数列表不匹配也不会跑到父类再去匹配下，因为找到了就不再找了，因此有了类型不匹配的错误。
 */
public class Test2 {

    public static void main(String[] args) {
        Parent parent = new Son();
        parent.print("name");

        Son son = new Son();
//        son.print("");
    }
}

class Son extends Parent{

    @Override
    public void print(String[] strs) {

    }
}

class Parent{

    public void print(String... srgs){

    }
}