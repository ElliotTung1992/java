package com.github.demo.utils.hutool;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.clone.Cloneable;
import cn.hutool.core.util.ObjectUtil;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 董感恩
 * @date 2020-03-10 16:58
 * @desc
 */
public class CloneTest {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Cat clone = cat.clone();
        System.out.println(clone);

        Dog dog = new Dog();
        dog.setCat(clone);
        Dog clone1 = dog.clone();
        Dog clone2 = dog.clone();

        System.out.println(clone1);
        System.out.println(clone2);
        System.out.println("===========");
        clone.setName("fnn");
        System.out.println(clone1);
        System.out.println(clone2);

        System.out.println("-----------");

        Pig pig = new Pig();
        pig.setName("猪");
        Monkey monkey = new Monkey();
        monkey.setName("猴子");
        pig.setMonkey(monkey);
        Pig pig1 = ObjectUtil.cloneByStream(pig);
        Pig pig2 = ObjectUtil.cloneByStream(pig);
        System.out.println(pig1);
        System.out.println(pig2);
        System.out.println("===========");
        Monkey monkey1 = pig1.getMonkey();
        monkey1.setName("猴子2");
        System.out.println(pig1);
        System.out.println(pig2);
    }

    @Data
    @ToString
    private static class Cat implements Cloneable<Cat>{

        private String name = "dge";
        private Integer age = 10;

        @Override
        public Cat clone() {
            try {
                return (Cat) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new CloneRuntimeException(e);
            }
        }
    }

    @Data
    @ToString
    private static class Dog extends CloneSupport<Dog>{
        private Cat cat;
        private String name = "wangwang";
        private int age = 3;
    }

    @Data
    @ToString
    private static class Pig implements Serializable{
        private Monkey monkey;
        private String name;
    }

    @Data
    @ToString
    private static class Monkey implements Serializable{
        private String name;
    }
}
