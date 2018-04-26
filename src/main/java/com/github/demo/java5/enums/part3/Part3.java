package com.github.demo.java5.enums.part3;

public class Part3 {

    public static void main(String[] args) {
        WeekEnum[] values = WeekEnum.values();
        for (WeekEnum weekEnum:values) {
            System.out.println(weekEnum.name() + " " + weekEnum.getDesc());
        }
    }
}

/**
 * 使用枚举定义常量
 */
enum  WeekEnum{
    SUNDAY("星期日"),
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六");

    //自定义变量
    private String desc;

    //自定义构造函数
    WeekEnum(String desc){
        this.desc = desc;
    }

    //返回描述
    public String getDesc() {
        return desc;
    }
}
