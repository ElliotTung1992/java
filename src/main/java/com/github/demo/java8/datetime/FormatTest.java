package com.github.demo.java8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * LocalDateTime API
 */
public class FormatTest {

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


        //获取UAT时间    毫秒
        LocalDateTime of = LocalDateTime.of(2018, 8, 5, 0, 0, 0);
        System.out.println(of.toInstant(ZoneOffset.of("+7")).toEpochMilli());

        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");

        long l = ZonedDateTime.of(of, ZoneId.of("Asia/Shanghai")).toEpochSecond();
        System.out.println(l);


        Date date = new Date();
        Calendar cal =
                Calendar.getInstance(TimeZone.getDefault());
        cal.setTime(date);
        long time = date.getTime() + cal.getTimeZone().getRawOffset();
        System.out.println(time);

        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(milliSecond);
    }
}
