package com.github.demo.designPattern.strategy;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ReflectUtil;
import org.reflections.Reflections;

import java.util.Set;

/**
 * @author 董感恩
 * @date 2020-05-09 17:57
 * @desc
 */
public class Traveler {

    TravelStrategy travelStrategy;

    public Traveler(TravelStrategy travelStrategy){
        this.travelStrategy = travelStrategy;
    }

    public void travelStyle(){
        String travel = travelStrategy.travel();
        System.out.println(travel);
    }

    public static void main(String[] args) {

        Reflections reflections = new Reflections("com.github.demo.designPattern.strategy");
        //获取带TravelInterface注解的类
        Class clazz2 = null;
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(TravelInterface.class);
        for (Class clazz:typesAnnotatedWith) {
            String annotationValue = AnnotationUtil.getAnnotationValue(clazz, TravelInterface.class, "value");
            if(annotationValue.equals("car")){
                clazz2  = clazz;
            }
        }
        Traveler traveler = new Traveler((TravelStrategy)ReflectUtil.newInstance(clazz2));
        traveler.travelStyle();
    }
}
