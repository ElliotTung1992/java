package com.github.demo.designPattern.proxy.static_proxy;

/**
 * @author 董感恩
 * @date 2020-07-24 16:59
 * @desc
 */
public class CatExtend extends Cat{

    @Override
    public void run() {
        System.out.println("开始日志记录");
        super.run();
        System.out.println("结束日志记录");
    }
}
