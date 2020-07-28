package com.github.demo.designPattern.observer;

import java.util.Vector;

/**
 * @author 董感恩
 * @date 2020-07-21 10:38
 * @desc 主题
 */
public abstract class Subject {

    private Vector<Observer> vector = new Vector<>();

    public void attach(Observer observer){
        vector.add(observer);
    }

    public void detach(Observer observer){
        vector.remove(observer);
    }

    public void notifyObserver(Object arg){
        for (Observer observer:vector) {
            observer.update(this, arg);
        }
    }
}
