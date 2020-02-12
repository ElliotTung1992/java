package com.github.demo.java8.datetime;

import java.time.*;
import java.util.Date;

//日期对象之间转换
public class TransformTest {

    public static void main(String[] args) {
        //localDate -> Date
        Date date = test1(LocalDate.now());
        System.out.println(date);

        //LocalDateTime -> Date
        Date date1 = test2(LocalDateTime.now());
        System.out.println(date1);

        //Date -> LocalDate
        LocalDate localDate = test3(new Date());
        System.out.println(localDate);

        //Date -> LocalDateTime
        LocalDateTime localDateTime = test4(new Date());
        System.out.println(localDateTime);
    }

    private static LocalDateTime test4(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    private static LocalDate test3(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }

    private static Date test2(LocalDateTime localDateTime) {
        ZonedDateTime atZone = localDateTime.atZone(ZoneId.systemDefault());
        Date date = Date.from(atZone.toInstant());
        return date;
    }

    private static Date test1(LocalDate localDate) {
        ZonedDateTime atZone = localDate.atStartOfDay(ZoneId.systemDefault());
        Date date = Date.from(atZone.toInstant());
        return date;
    }
}
