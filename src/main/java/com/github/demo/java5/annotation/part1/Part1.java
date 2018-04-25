package com.github.demo.java5.annotation.part1;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * 使用@Inherited
 */
public class Part1 {

    public static void main(String[] args) {
        A b = new B();
        System.out.println(Arrays.toString(b.getClass().getAnnotations()));
        C d = new D();
        System.out.println(Arrays.toString(d.getClass().getAnnotations()));

        Class<? extends A> clazz = b.getClass();
        boolean annotationPresent = clazz.isAnnotationPresent(AnnotationThree.class);
        System.out.println(annotationPresent);

        AnnotationThree annotationThree = clazz.getAnnotation(AnnotationThree.class);
        System.out.println(annotationThree);

        Annotation[] annotations = clazz.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        AnnotationThree[] annotationsByType = clazz.getAnnotationsByType(AnnotationThree.class);
        System.out.println(Arrays.toString(annotationsByType));

        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        System.out.println(Arrays.toString(declaredAnnotations));

        E f = new F();
        Class<? extends E> fClass = f.getClass();
        NameValue[] annotationsByType1 = fClass.getAnnotationsByType(NameValue.class);
        NameValue[] declaredAnnotationsByType = fClass.getDeclaredAnnotationsByType(NameValue.class);
        for (NameValue nameValue:annotationsByType1) {
            System.out.println(nameValue.value());
        }

        for (NameValue nameValue:declaredAnnotationsByType) {
            System.out.println(nameValue.value());
        }
    }
}

/**
 * 注解一
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationOne {

}

/**
 * 注解二
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationTwo {

}

/**
 * 注解三
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationThree {

}

/**
 * 注解四
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
@interface NameValues{
    NameValue[] value();
}

/**
 * 注解五
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(NameValues.class)
//@Inherited
@interface NameValue{
    String value();
}

@AnnotationOne
class A{

}

@AnnotationThree
class B extends A{

}

@AnnotationTwo
class C{

}

class D extends C{

}

@NameValue("one")
class E{

}

@NameValue("two")
@NameValue("three")
@NameValue("four")
class F extends E{

}

