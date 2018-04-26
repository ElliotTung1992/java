package com.github.demo.java5.enums.part1;

public class Part1 {

    public static void main(String[] args) {
        WeekPreTest(1);
        WeekPreTest(WeekPre.MONDAY);
        WeekEnumTest(WeekEnum.MONDAY);
    }

    public static void WeekPreTest(int i){
        if(i == WeekPre.MONDAY){
            System.out.println("星期一");
        }
    }

    public static void WeekEnumTest(WeekEnum weekEnum){
        if(weekEnum == WeekEnum.MONDAY){
            System.out.println("星期一");
        }
    }
}

/**
 * 使用普通方式定义星期常量
 */
class WeekPre{
    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;
}

/**
 * 使用枚举定义常量
 */
enum  WeekEnum{
    SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY;
}
