package com.github.demo.java.object;

import java.util.Objects;

/**
 * @author 董感恩
 * @date 2020-02-12 12:47
 * @desc 对象重写equals和hashCode方法测试
 */
public class EqualsAndHashCodeTest {

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("dge");
        person1.setAge(10);

        Person person2 = new Person();
        person2.setName("dge");
        person2.setAge(10);

        System.out.println(person1.equals(person2));
        System.out.println(person1 == person2);
    }
}

class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
