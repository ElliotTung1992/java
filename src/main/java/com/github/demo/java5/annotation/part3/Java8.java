package com.github.demo.java5.annotation.part3;

import java.lang.annotation.*;

/**
 * Repeatable 注解的使用
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Java8Group.class)
public @interface Java8 {
    String value();
}

//
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Java8Pre{
    String[] value();
}

//
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Java8Group{
    Java8[] value();
}

//Java8之前
@Java8Pre({"one", "two"})
class A{

}

//Java8
@Java8(value = "one")
@Java8(value = "two")
class B{

}
