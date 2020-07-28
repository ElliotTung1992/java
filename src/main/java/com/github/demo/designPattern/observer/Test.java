package com.github.demo.designPattern.observer;

/**
 * @author 董感恩
 * @date 2020-07-21 10:47
 * @desc
 */
public class Test {

    public static void main(String[] args) {
        //创建主题
        Subject subject = new ConcreteSubject();
        //创建观察者
        new ConcreteObserver(subject);
        new ConcreteObserver(subject);

        subject.notifyObserver("哈哈");
    }
}
