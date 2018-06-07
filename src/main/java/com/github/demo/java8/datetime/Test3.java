package com.github.demo.java8.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * LocalDateTime API
 */
public class Test3 {

    public static void main(String[] args) {
        //获取当前日期时间
        LocalDateTime now = LocalDateTime.now();

        //格式化
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(now.format(DateTimeFormatter.ISO_TIME));
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(now.format(DateTimeFormatter.ISO_DATE_TIME));

        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));

        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
    }
}
