package com.github.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

/**
 * @Author 小眼睛带鱼
 * @Description
 * @Date 2019/7/26
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int id;
    private String name;
    private int age;
}
