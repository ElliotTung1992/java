package com.github.demo.domain;

import lombok.Data;

/**
 * @Author 小眼睛带鱼
 * @Description
 * @Date 2019/7/29
 **/
@Data
public class Bar {
    String name;

    public Bar(String name) {
        this.name = name;
    }
}
