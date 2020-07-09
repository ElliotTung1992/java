package com.github.demo.designPattern.proxy.self_dynamic_proxy;

import java.lang.reflect.Method;

/**
 * @author 董感恩
 * @date 2020-07-08 16:00
 * @desc
 */
public interface InvocationHandler {
    void invoke(Object proxy, Method method, Object[] args);
}
