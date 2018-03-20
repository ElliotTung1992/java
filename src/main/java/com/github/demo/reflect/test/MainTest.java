package com.github.demo.reflect.test;

import com.github.demo.reflect.demo.Student;

import java.lang.reflect.Method;

public class MainTest {

    public static void main(String[] args) {

        Class<Student> clazz = Student.class;

        try {
            Method method = clazz.getMethod("main", String[].class);
            method.invoke(null, (Object) new String[]{"a", "b", "c"});
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
