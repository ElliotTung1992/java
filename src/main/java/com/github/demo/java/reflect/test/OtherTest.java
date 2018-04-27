package com.github.demo.java.reflect.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过反射越过泛型检查
 */
public class OtherTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();

        list.add("dong");
        list.add("feng");

        Class<? extends List> clazz = list.getClass();
        Method method = clazz.getMethod("add", Object.class);
        method.invoke(list, 23);

        for (Object obj:list) {
            System.out.println(obj);
        }
    }
}
