package com.github.demo.java8.functional_interface;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

/**
 * @Author 小眼睛带鱼
 * @Description
 * @Date 2019/8/2
 **/
public class SupplierTest {

    public static void main(String[] args){
        //test1();
        //test2();
        test3();
    }

    private static void test3() {
        DoubleSupplier doubleSupplier = () -> 2.7;
        System.out.println(doubleSupplier.getAsDouble());
    }

    private static void test2() {
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println(booleanSupplier.getAsBoolean());
    }

    private static void test1() {
        Supplier<String> supplier = () -> "hello";
        System.out.println(supplier.get());
    }

}
