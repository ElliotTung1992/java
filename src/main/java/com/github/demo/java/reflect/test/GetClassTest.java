package com.github.demo.java.reflect.test;

import com.github.demo.java.reflect.demo.Student;

/**
 * 获取Class对象的3种方式
 */
public class GetClassTest {

    public static void main(String[] args) {
        Student student = new Student();

        Class<? extends Student> clazz1 = student.getClass();
        System.out.println(clazz1);

        Class<Student> clazz2 = Student.class;
        System.out.println(clazz2);

        try {
            Class<?> clazz3 = Class.forName("com.github.demo.java.reflect.demo.Student");
            System.out.println(clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
