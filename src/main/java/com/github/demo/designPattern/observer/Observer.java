package com.github.demo.designPattern.observer;

/**
 * @author 董感恩
 * @date 2020-07-21 10:38
 * @desc 观察者
 */
public interface Observer {

    void update(Subject subject, Object arg);
}
