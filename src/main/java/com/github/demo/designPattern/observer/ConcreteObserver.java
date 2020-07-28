package com.github.demo.designPattern.observer;

/**
 * @author 董感恩
 * @date 2020-07-21 10:40
 * @desc
 */
public class ConcreteObserver implements Observer{

    ConcreteObserver(Subject subject){
        subject.attach(this);
    }

    @Override
    public void update(Subject subject, Object arg) {
        System.out.println(arg + " ConcreteObserver 接收到了");
    }
}
