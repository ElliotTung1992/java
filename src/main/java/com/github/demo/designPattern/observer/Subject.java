package com.github.demo.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小眼睛带鱼
 * @date 2019-12-11 17:55
 * @desc 主题
 */
public class Subject {

    private String message;
    private List<Observer> observers = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setState(String message) {
        this.message = message;
        notifyAllObserver();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notifyAllObserver(){
        observers.stream().forEach(e -> e.update());
    }
}
