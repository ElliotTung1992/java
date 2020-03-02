package com.github.demo.java.basics.string;

import java.util.UUID;

/**
 * @author 董感恩
 * @date 2020-02-28 13:48
 * @desc
 */
public class CreateUUIDTest {

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(uuid);
    }
}
