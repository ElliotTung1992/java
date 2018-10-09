package com.github.demo.java8.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * LocalDate API 熟悉
 */
public class Test1 {

    public static void main(String[] args) {

        //获取当前日期
        LocalDate now = LocalDate.now();
        System.out.println(now);
        //获取当前时间的年份
        System.out.println(now.getYear());
        //获取当前月份对象
        System.out.println(now.getMonth());
        //获取当前月份值
        System.out.println(now.getMonthValue());
        //获取当前日期日子
        System.out.println(now.getDayOfMonth());
        //获取当前日期星期
        System.out.println(now.getDayOfWeek());
        //获取当前日期是一年的第几天
        System.out.println(now.getDayOfYear());

        //获取当前日期的开始日期时间
        System.out.println(now.atStartOfDay());
        System.out.println(now.atStartOfDay(ZoneId.of(ZoneId.SHORT_IDS.get("CTT"))));
        //获取当前日期时间
        System.out.println(now.atTime(LocalTime.now()));
        //指定当前日期时间
        System.out.println(now.atTime(20, 10, 10));

        //格式化时间
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(now.format(DateTimeFormatter.ISO_ORDINAL_DATE));
        System.out.println(now.format(DateTimeFormatter.ISO_WEEK_DATE));

        //比较日期
        System.out.println(now.isAfter(LocalDate.MAX));
        System.out.println(now.isAfter(LocalDate.MIN));

        System.out.println(now.isBefore(LocalDate.MAX));
        System.out.println(now.isBefore(LocalDate.MIN));

        System.out.println(now.isEqual(LocalDate.now()));

        //判断是否是闰年
        System.out.println(now.isLeapYear());

        //当前月份有几天
        System.out.println(now.lengthOfMonth());
        //当年有几天
        System.out.println(now.lengthOfYear());

        //往前退几天
        System.out.println(now.minusDays(5));
        //往前退几月
        System.out.println(now.minusMonths(2));
        //往前退几周
        System.out.println(now.minusWeeks(1));
        //往前退几年
        System.out.println(now.minusYears(10));

        //往前进几天
        System.out.println(now.plusDays(20));
        //往前进几周
        System.out.println(now.plusWeeks(2));
        //往前进几月
        System.out.println(now.plusMonths(3));
        //往前进几年
        System.out.println(now.plusYears(20));

        //修改当前日期的日子
        System.out.println(now.withDayOfMonth(30));
        //修改当前年的第几天
        System.out.println(now.withDayOfYear(158));
        //修改当前日期的月份
        System.out.println(now.withMonth(10));
        //修改当前日期的年份
        System.out.println(now.withYear(2000));

        //获取最大日期
        System.out.println(LocalDate.MAX);//+999999999-12-31
        //获取最小日期
        System.out.println(LocalDate.MIN);//-999999999-01-01

        //自定义日期
        System.out.println(LocalDate.of(1992, 06, 26));

        //1970-01-01往后推几天
        System.out.println(LocalDate.ofEpochDay(30));

        //获取本月第一天
        LocalDate firstLocalDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstLocalDate);

        LocalDate lastLocalDate = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastLocalDate);
    }
}
