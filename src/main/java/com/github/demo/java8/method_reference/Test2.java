package com.github.demo.java8.method_reference;

import java.util.*;
import java.util.function.Supplier;

/**
 * 方法引用不同的形式
 */
public class Test2 {

    public static void main(String[] args) {

        //引用静态方法
//        test1();

        //引用对象的实例方法
//        test2();

        //引用类型对象的实例方法
//        test3();

        //引用构造方法
        test4();

    }

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(SOURCE sourceColletions, Supplier<DEST> colltionFactory) {
        DEST result = colltionFactory.get();
        for (T t : sourceColletions) {
            result.add(t);
        }
        return result;
    }

    private static void test4() {
        Person[] persons = {new Person("dong", 27), new Person("yan", 18),
                new Person("feng", 26), new Person("wang", 29)};

        final List<Person> personList = Arrays.asList(persons);

        Set<Person> personSet2 = transferElements(personList, HashSet::new);

        for (Person p:personSet2) {
            System.out.println(p);
        }
    }

    private static void test3() {
        String[] strs = {"c", "a", "b"};
        Arrays.sort(strs, String::compareToIgnoreCase);

        for (String s:strs) {
            System.out.println(s);
        }
    }

    private static void test2() {
        Person[] persons = {new Person("dong", 27), new Person("yan", 18),
                new Person("feng", 26), new Person("wang", 29)};

        ComparisonProvider comparisonProvider = new ComparisonProvider();

        Arrays.sort(persons, comparisonProvider::compareByAge);

        for (Person p:persons) {
            System.out.println(p);
        }
    }

    private static void test1() {
        Person[] persons = {new Person("dong", 27), new Person("yan", 18),
                            new Person("feng", 26), new Person("wang", 29)};

        //使用匿名类
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge().compareTo(p2.getAge());
            }
        });

        for (Person p:persons) {
            System.out.println(p);
        }

        System.out.println("===========================");

        //lambda表达式
        Person[] persons2 = {new Person("dong", 27), new Person("yan", 18),
                new Person("feng", 26), new Person("wang", 29)};

        Arrays.sort(persons2, (p1, p2) -> p1.getAge().compareTo(p2.getAge()));

        for (Person p:persons2) {
            System.out.println(p);
        }

        System.out.println("===========================");

        //使用lambda表达式和类的静态方法
        Person[] persons3 = {new Person("dong", 27), new Person("yan", 18),
                new Person("feng", 26), new Person("wang", 29)};

        Arrays.sort(persons3, (p1, p2) -> Person.compareAge(p1, p2));

        for (Person p:persons3) {
            System.out.println(p);
        }

        System.out.println("===========================");

        //引用的是类的静态方法
        Person[] persons4 = {new Person("dong", 27), new Person("yan", 18),
                new Person("feng", 26), new Person("wang", 29)};

        Arrays.sort(persons4, Person::compareAge);

        for (Person p:persons4) {
            System.out.println(p);
        }
    }
}

class Person{

    public enum Sex{
        MALE,FEMALE
    }

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public static int compareAge(Person p1, Person p2){
        return p1.getAge().compareTo(p2.getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class ComparisonProvider{

    public int compareByAge(Person a,Person b){
        return a.getAge().compareTo(b.getAge());
    }
}
