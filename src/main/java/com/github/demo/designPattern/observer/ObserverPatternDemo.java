package com.github.demo.designPattern.observer;

/**
 * @author 小眼睛带鱼
 * @date 2019-12-11 18:41
 * @desc 观察者模式案例
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();
        DemoObserver demoObserver = new DemoObserver(subject);
        subject.attach(demoObserver);
        subject.setState("哈哈");
        subject.detach(demoObserver);
        subject.setState("呵呵");
    }
}
