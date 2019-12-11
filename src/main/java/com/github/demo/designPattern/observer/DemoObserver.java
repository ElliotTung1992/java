package com.github.demo.designPattern.observer;

/**
 * @author 小眼睛带鱼
 * @date 2019-12-11 18:38
 * @desc 观察者示例
 */
public class DemoObserver extends Observer{

    public DemoObserver(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println("监听的消息是:" + subject.getMessage());
    }
}
