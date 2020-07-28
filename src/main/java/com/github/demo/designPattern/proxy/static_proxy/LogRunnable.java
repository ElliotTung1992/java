package com.github.demo.designPattern.proxy.static_proxy;

/**
 * @author 董感恩
 * @date 2020-07-24 17:01
 * @desc 使用聚合
 */
public class LogRunnable implements Runnable {

    private Runnable runnable;

    LogRunnable(Runnable runnable){
        this.runnable = runnable;
    }

    @Override
    public void run() {
        System.out.println("开始日志记录");
        runnable.run();
        System.out.println("结束日志记录");
    }
}
