package com.github.demo.java5.generics.part2;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        AnimalUtil<Dog> animalAnimalUtil = new AnimalUtil<>();
        List<Dog> dogs = animalAnimalUtil.get(new Dog());
        System.out.println(dogs);
    }
}
