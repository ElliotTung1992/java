package com.github.demo.reflect.test;

import com.github.demo.reflect.demo.Student;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class ConstructorTest {

    public static void main(String[] args) {

        Class<Student> clazz = Student.class;

        //获取所有的public构造方法
        Constructor<?>[] constructors = clazz.getConstructors();
        Arrays.stream(constructors).forEach(e -> System.out.println(e));
        System.out.println("---------------");

        //获取所有的(默认、共有、保护、私有)构造方法
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        Arrays.stream(declaredConstructors).forEach(e -> System.out.println(e));
        System.out.println("---------------");

        //获取单个的public的构造方法
        try {
            //获取公开的无参的构造函数
            Constructor<Student> constructor = clazz.getConstructor(null);
            Student student = constructor.newInstance();
            System.out.println(constructor);

            //获取公开的有两个参数的构造函数
            Constructor<Student> constructor2 = clazz.getConstructor(String.class, Integer.class);
            Student student1 = constructor2.newInstance("小明", 12);
            System.out.println(student1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---------------");

        //获取单个private的构造函数
        try {
            Constructor<Student> declaredConstructor = clazz.getDeclaredConstructor(Integer.class);
            declaredConstructor.setAccessible(true);
            Student student = declaredConstructor.newInstance(12);
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
