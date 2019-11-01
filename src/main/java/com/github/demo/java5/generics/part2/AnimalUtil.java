package com.github.demo.java5.generics.part2;

import java.util.ArrayList;
import java.util.List;

public class AnimalUtil<T extends Animal> {

    public List<T> get(T t){
        List<T> list = new ArrayList<>();
        Animal animal = new Animal();
        animal.setName("小狗");
        list.add(t);
        list.add((T) animal);
        return list;
    }
}
