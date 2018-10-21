package com.github.demo.java.characteristic;

public class Student extends Person{
    static String staticFiled = "Student staticFiled";
    String filed = "Student filed";
    static{
        System.out.println("Student " + staticFiled);
        staticFiled = "Student block staticFiled";
    }
    {
        System.out.println(staticFiled);
        System.out.println(filed);
        filed = "Student block filed";
    }
    public Student(){
        System.out.println(filed);
    }

    public static void main(String[] args) {
        Student student = new Student();
    }
}

class Person {
    static String staticFiled = "Person staticFiled";
    String filed = "Person filed";
    static{
        System.out.println("Person " + staticFiled);
        staticFiled = "Person block staticFiled";
    }
    {
        System.out.println(staticFiled);
        System.out.println(filed);
        filed = "Person block filed";
    }
    public Person(){
        System.out.println(filed);
    }
}
