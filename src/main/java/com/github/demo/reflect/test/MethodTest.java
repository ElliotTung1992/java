package com.github.demo.reflect.test;

import com.github.demo.reflect.demo.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {

    public static void main(String[] args) {
        Class<Student> clazz = Student.class;

        //获取所有public方法
        Method[] methods = clazz.getMethods();
        Arrays.stream(methods).forEach(e -> System.out.println(e));
        System.out.println("-------------");

        //获取所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(e -> System.out.println(e));
        System.out.println("-------------");

        //获取单个public方法
        try {
            Method method = clazz.getMethod("show1", String.class);
            Constructor<Student> constructor = clazz.getConstructor();
            Student student = constructor.newInstance();
            method.invoke(student, "小白");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--------------");

        //获取单个private方法
        try {
            Method method = clazz.getDeclaredMethod("show4", Integer.class);
            Constructor<Student> constructor = clazz.getConstructor();
            Student student = constructor.newInstance();
            method.setAccessible(true);
            method.invoke(student, 12);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
