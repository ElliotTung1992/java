package com.github.demo.java8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

/**
 * @Author 小眼睛带鱼
 * @Description
 * @Date 2019/7/25
 **/
public class DateTimeFormatterTest {

    public static void main(String[] args){
        System.out.println("标准格式实例化日期：" + DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.of(2018, 3, 9)));
        System.out.println("解析带偏移量的日期: " + DateTimeFormatter.ISO_OFFSET_DATE.format(LocalDate.of(2018, 3, 9).atStartOfDay(ZoneId.of(ZoneId.SHORT_IDS.get("CTT")))));
        System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(LocalDate.of(2018, 3, 9).atStartOfDay(ZoneId.of("UTC-3"))));
        //字符串时间格式转换成日期形式
        LocalDate localDate = LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse("2018-03-09"));
        System.out.println(localDate.plusDays(3));

        //不通风格格式化日期
        LocalDate anotherSummerDay = LocalDate.of(2016, 8, 23);
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(anotherSummerDay));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(anotherSummerDay));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(anotherSummerDay));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(anotherSummerDay));

        LocalTime anotherTime = LocalTime.of(13, 12, 45);
        System.out.println(anotherTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(anotherSummerDay, anotherTime, ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);

        System.out.println(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                        .format(zonedDateTime));

        System.out.println(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)
                        .format(zonedDateTime));

        System.out.println(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                        .format(zonedDateTime));

        System.out.println(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                        .format(zonedDateTime));

        LocalDateTime now = LocalDateTime.now();

        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(now, ZoneId.of("Asia/Shanghai"));
        System.out.println(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                        .format(zonedDateTime2));

        ZonedDateTime dateTime = ZonedDateTime.from(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                        .parse("2016年8月23日星期二 中国标准时间 下午1:12:45"));
        System.out.println(dateTime.plusHours(9));

        //自定义时间格式

        /**
         * @author dongganen
         * @date 2019/7/25
         * @desc:
         *     u       year 
         *     y       year-of-era
         *     M/L     month-of-year
         *     d       day-of-month
         *     H       hour-of-day (0-23)          number            0
         *     m       minute-of-hour              number            30
         *     s       second-of-minute            number            55
         *     S       fraction-of-second          fraction          978
         *     n       nano-of-second              number            987654321
         */
        String europeanDatePattern = "yyyy/MM/dd";
        DateTimeFormatter europeanDateFormatter2 = DateTimeFormatter.ofPattern(europeanDatePattern);
        System.out.println(europeanDateFormatter2.format(LocalDate.of(2016, 7, 31)));

        DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println(LocalDate.from(europeanDateFormatter.parse("15.08.2014")).isLeapYear());

        String timeColonPattern = "HH:mm:ss";
        DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(timeColonPattern);
        LocalTime colonTime = LocalTime.of(17, 35, 50);
        System.out.println(timeColonFormatter.format(colonTime));

        String timeColonPattern2 = "HH:mm:ss SSS";
        DateTimeFormatter timeColonFormatter2 = DateTimeFormatter.ofPattern(timeColonPattern2);
        LocalTime colonTime2 = LocalTime.of(17, 35, 50).plus(329, ChronoUnit.MILLIS);
        System.out.println(timeColonFormatter2.format(colonTime2));

        String timeColonPattern3 = "hh:mm:ss a";
        DateTimeFormatter timeColonFormatter3 = DateTimeFormatter.ofPattern(timeColonPattern3);
        LocalTime colonTime3 = LocalTime.of(17, 35, 50);
        System.out.println(timeColonFormatter3.format(colonTime3));

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        System.out.println(LocalTime.from(timeFormatter.parse("12:25:30 上午")).isBefore(LocalTime.NOON));

        //格式化时间
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(now.format(DateTimeFormatter.ISO_ORDINAL_DATE));
        System.out.println(now.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

    }
}
