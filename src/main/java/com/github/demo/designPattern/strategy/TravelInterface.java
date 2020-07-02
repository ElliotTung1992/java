package com.github.demo.designPattern.strategy;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author 董感恩
 * @date 2020-05-09 19:05
 * @desc
 */
@Documented
@Target({ ElementType.TYPE})
@Retention(RUNTIME)
public @interface TravelInterface {
    String value() default "";
}
