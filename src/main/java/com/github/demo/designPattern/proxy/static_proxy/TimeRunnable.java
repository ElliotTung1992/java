package com.github.demo.designPattern.proxy.static_proxy;

/**
 * @author 董感恩
 * @date 2020-07-24 17:03
 * @desc
 */
public class TimeRunnable implements Runnable {

    private Runnable runnable;

    TimeRunnable(Runnable runnable){
        this.runnable = runnable;
    }

    @Override
    public void run() {
        System.out.println("计时开始");
        runnable.run();
        System.out.println("计时结束");
    }
}
