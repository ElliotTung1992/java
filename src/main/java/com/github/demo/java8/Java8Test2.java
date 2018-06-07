package com.github.demo.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 函数组合与集合管道模式
 */
public class Java8Test2 {

    public static void main(String[] args) {
        /**
         * 我们使用命令式编程来迭代该列表，
         * 并获取 2000 年后制造的汽车的名称。
         * 然后按年份对这些型号进行升序排序。
         */
        test1();

        /**
         * 使用集合管道进行迭代和排序
         */
        test2();
    }

    private static void test2() {
        List<Car> cars = createCars();
        List<String> collect = cars.stream()
                .filter(car -> car.getYear() > 2000)
                .sorted(Comparator.comparing(Car::getYear))
                .map(Car::getModel)
                .collect(Collectors.toList());

        collect.stream().forEach(System.out::println);
    }

    private static void test1() {
        List<Car> cars = createCars();
        List<Car> carsSortedByYear = new ArrayList<>();

        for(Car car : cars) {
            if(car.getYear() > 2000) {
                carsSortedByYear.add(car);
            }
        }

        Collections.sort(carsSortedByYear, new Comparator<Car>() {
            public int compare(Car car1, Car car2) {
                return new Integer(car1.getYear()).compareTo(car2.getYear());
            }
        });

        List<String> models = new ArrayList<>();
        for(Car car : carsSortedByYear) {
            models.add(car.getModel());
        }

        for (String str:models) {
            System.out.println(str);
        }
    }

    public static List<Car> createCars() {
        return Arrays.asList(
                new Car("Jeep", "Wrangler", 2011),
                new Car("Jeep", "Comanche", 1990),
                new Car("Dodge", "Avenger", 2010),
                new Car("Buick", "Cascada", 2016),
                new Car("Ford", "Focus", 2012),
                new Car("Chevrolet", "Geo Metro", 1992)
        );
    }
}

class Car {
    private String make;
    private String model;
    private int year;

    public Car(String theMake, String theModel, int yearOfMake) {
        make = theMake;
        model = theModel;
        year = yearOfMake;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}
