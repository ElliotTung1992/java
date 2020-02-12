package com.github.demo.java8.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;

/**
 * LocalDate API 熟悉
 */
public class LocalDateTest {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println("获取当前日期:" + now);
        System.out.println("获取当前年份:" + now.getYear());
        System.out.println("获取当前月份(英文月份):" + now.getMonth());
        System.out.println("获取当前月份值(数字):" + now.getMonthValue());
        System.out.println("获取当前日子:" + now.getDayOfMonth());
        System.out.println("获取今天是周几:" + now.getDayOfWeek());
        System.out.println("获取今天是今年的第几日:" + now.getDayOfYear());

        System.out.println("获取当前周的周一:" + now.with(DayOfWeek.MONDAY));

        System.out.println("获取当前日期的开始时间:" + now.atStartOfDay());
        System.out.println("获取当前日期的开始时间加上时区:" + now.atStartOfDay(ZoneId.of(ZoneId.SHORT_IDS.get("CTT"))));
        System.out.println("获取当前日期加上时分秒" + now.atTime(LocalTime.now()));
        System.out.println("获取当前日期指定时分秒" + now.atTime(20, 10, 10));

        //比较日期
        System.out.println(now.isAfter(LocalDate.MAX));
        System.out.println(now.isAfter(LocalDate.MIN));

        System.out.println(now.isBefore(LocalDate.MAX));
        System.out.println(now.isBefore(LocalDate.MIN));

        System.out.println(now.isEqual(LocalDate.now()));

        System.out.println("判断今年是否是闰年:" + now.isLeapYear());
        System.out.println("查看本月一共有几天:" + now.lengthOfMonth());
        System.out.println("查看今年一共有几天:" + now.lengthOfYear());
        System.out.println("往后退几天:" + now.minusDays(5));
        System.out.println("往后退几月:" + now.minusMonths(2));
        System.out.println("往后退几周:" + now.minusWeeks(1));
        System.out.println("往后退几年:" + now.minusYears(10));

        System.out.println("往前进几天:" + now.plusDays(20));
        System.out.println("往前进几周:" + now.plusWeeks(2));
        System.out.println("往前进几月:" + now.plusMonths(3));
        System.out.println("往前进几年:" + now.plusYears(20));

        System.out.println("修改当前日期的日子:" + now.withDayOfMonth(30));
        System.out.println("修改当前年的第几天:" + now.withDayOfYear(158));
        System.out.println("修改当前日期的月份:" + now.withMonth(10));
        System.out.println("修改当前日期的年份:" + now.withYear(2000));

        System.out.println("获取最大日期:" + LocalDate.MAX);
        System.out.println("获取最小日期" + LocalDate.MIN);
        System.out.println("自定义日期:" + LocalDate.of(1992, 06, 26));
        System.out.println("1970-01-01往后退几天:" + LocalDate.ofEpochDay(30));
        LocalDate firstLocalDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("获取本月第一天:" + firstLocalDate);
        LocalDate lastLocalDate = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("获取本月最后一天:" + lastLocalDate);

        int a =LocalDate.of(2019, 7, 25).getDayOfYear() - LocalDate.now().getDayOfYear();
        System.out.println(a);

        System.out.println(LocalDate.now().toEpochDay());
        System.out.println(LocalDate.of(2019, 7, 25).toEpochDay());
    }
}
