package com.github.demo.java.basics.statictest;

public class TransmitTest {

    public static void main(String[] args) {
        //值传递
        passByValue();
        //引用传递
        referenceTransfer();
    }

    private static void referenceTransfer() {
        Person person = new Person();
        person.setAge(10);
        swapAge(person);
        System.out.println(person.getAge());
    }

    private static void swapAge(Person person) {
        person.setAge(20);
    }

    private static void passByValue() {
        int a = 10;
        int b = 20;
        swap(10, 20);
        System.out.println("a:" + a + " b:" + b);
    }

    private static void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }

    static class Person{
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
