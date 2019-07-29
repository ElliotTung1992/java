package com.github.demo.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 小眼睛带鱼
 * @Description
 * @Date 2019/7/29
 **/
@Data
public class Foo {
    String name;
    public List<Bar> bars = new ArrayList<>();

    public Foo(String name) {
        this.name = name;
    }
}
