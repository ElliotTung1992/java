package com.github.demo.java.basics.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author 董感恩
 * @date 2020-03-03 13:14
 * @desc BigDecimal基本的API使用
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        //test();
        test2();
    }

    /**
     * 校验BigDecimal
     * @author dge
     * @date 2021-01-14 13:38
     */
    private static void test2() {
        BigDecimal amount = new BigDecimal("80321099.0098");
        BigDecimal amount2 = new BigDecimal("0");
        //获取小数点右边的位数
        int scale = amount.scale();
        System.out.println(scale);
        //获取总的卫视
        int precision = amount.precision();
        System.out.println(precision);

        //校验大于0还是等于0或者小于0
        int signum = amount.signum();
        System.out.println(signum);

        int signum1 = amount2.signum();
        System.out.println(signum1);
    }

    /**
     * 设置保留小数进位问题
     * @author dge
     * @date 2021-01-14 13:30
     */
    private static void test() {
        BigDecimal amount = new BigDecimal("800");
        BigDecimal divide = amount.divide(new BigDecimal(3), 4, RoundingMode.HALF_UP);
        System.out.println(divide);

        BigDecimal bigDecimal = new BigDecimal("0.0001").setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal.toString());
    }
}
