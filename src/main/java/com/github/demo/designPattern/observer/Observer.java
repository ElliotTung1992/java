package com.github.demo.designPattern.observer;

/**
 * @author 小眼睛带鱼
 * @date 2019-12-11 17:54
 * @desc 观察者
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
