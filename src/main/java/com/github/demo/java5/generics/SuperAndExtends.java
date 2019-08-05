package com.github.demo.java5.generics;

import com.github.demo.domain.Apple;
import com.github.demo.domain.Food;
import com.github.demo.domain.Fruit;

/**
 * @Author 小眼睛带鱼
 * @Description
 *
 * <? extends T>：是指 “上界通配符（Upper Bounds Wildcards）”
 * <? super T>：是指 “下界通配符（Lower Bounds Wildcards）”
 *
 *
 * @Date 2019/8/2
 **/
public class SuperAndExtends {

    public static void main(String[] args){
        //正确
        Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());
        //错误
        //Plate<? extends Fruit> plate2 = new Plate<Food>(new Apple());
        //上界<? extends T>不能往里存，只能往外取
        //plate.set(new Apple());
        //plate.set(new Fruit());
        //plate.set(new Food());
        System.out.println(plate.get());

        //正确
        Plate<? super Fruit> plate3 = new Plate<Food>(new Apple());
        //错误
        //Plate<? super Fruit> plate4 = new Plate<Apple>(new Apple());
        //下界<? super T>不影响往里存，但往外取只能放在Object对象里
        plate3.set(new Apple());
        Object object = plate3.get();
        System.out.println(plate3.get());

        //PECS原则
        //频繁往外读取内容的，适合用上界Extends。
        //经常往里插入的，适合用下界Super。
    }
}

class Plate<T> {
    private T item;
    public Plate(T t){
        this.item = t;
    }
    public void set(T t){
        this.item = t;
    }
    public T get(){
        return this.item;
    }
}
