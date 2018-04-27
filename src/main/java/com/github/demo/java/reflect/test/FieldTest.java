package com.github.demo.java.reflect.test;

import com.github.demo.java.reflect.demo.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldTest {

    public static void main(String[] args) {
        Class<Student> clazz = Student.class;

        //获取所有public字段
        Field[] fields = clazz.getFields();
        Arrays.stream(fields).forEach(e -> System.out.println(e));
        System.out.println("-----------------");

        //获取所有字段
        Field[] declaredFields = clazz.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(e -> System.out.println(e));
        System.out.println("-------------------");

        //获取单个public字段
        try {
            //name字段
            Field name = clazz.getField("name");
            Constructor<Student> constructor = clazz.getConstructor();
            Student student = constructor.newInstance();
            name.set(student, "小红");
            System.out.println(student.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------------------");

        //获取单个私有字段
        try {
            Field age = clazz.getDeclaredField("age");
            Constructor<Student> constructor = clazz.getConstructor();
            Student student = constructor.newInstance();
            age.setAccessible(true);
            age.set(student, 23);
            System.out.println(student.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
