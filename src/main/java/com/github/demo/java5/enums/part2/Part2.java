package com.github.demo.java5.enums.part2;

public class Part2 {
    public static void main(String[] args) {
        String name = WeekEnum.MONDAY.name();
        System.out.println(name);
        int ordinal = WeekEnum.SATURDAY.ordinal();
        System.out.println(ordinal);
        System.out.println(WeekEnum.SATURDAY.toString());
        System.out.println(WeekEnum.SATURDAY.equals("SATURDAY"));
        System.out.println(WeekEnum.SATURDAY.equals(WeekEnum.MONDAY));
        System.out.println(WeekEnum.SATURDAY.equals(WeekEnum.SATURDAY));
        System.out.println(WeekEnum.MONDAY.hashCode());
        System.out.println(WeekEnum.MONDAY.hashCode());
        System.out.println(WeekEnum.SATURDAY.compareTo(WeekEnum.MONDAY));
        System.out.println(WeekEnum.SATURDAY.getDeclaringClass());
        System.out.println(WeekEnum.SATURDAY.getClass());
        System.out.println(WeekEnum.MONDAY.valueOf(WeekEnum.class, "MONDAY"));
    }
}

/**
 * 使用枚举定义常量
 */
enum  WeekEnum{
    SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY;
}
