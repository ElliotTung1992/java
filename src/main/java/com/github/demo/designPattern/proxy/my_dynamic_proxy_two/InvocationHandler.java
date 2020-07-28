package com.github.demo.designPattern.proxy.my_dynamic_proxy_two;

import java.lang.reflect.Method;

/**
 * @author 董感恩
 * @date 2020-07-08 16:00
 * @desc
 */
public interface InvocationHandler {
    void invoke(Object proxy, Method method, Object[] args);
}
