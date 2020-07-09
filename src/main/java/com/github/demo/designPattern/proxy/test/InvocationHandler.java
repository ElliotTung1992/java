package com.github.demo.designPattern.proxy.test;

import java.lang.reflect.Method;

/**
 * @author 董感恩
 * @date 2020-07-09 10:15
 * @desc 调用处理器
 */
public interface InvocationHandler {

    void invoke(Object proxy, Method method, Object[] args);
}
