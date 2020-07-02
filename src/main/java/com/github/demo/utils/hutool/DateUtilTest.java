package com.github.demo.utils.hutool;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author 董感恩
 * @date 2020-03-19 16:38
 * @desc
 */
public class DateUtilTest {

    public static void main(String[] args) {
        String dateStr = "2017-03-01 23:11:12";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);
    }
}
