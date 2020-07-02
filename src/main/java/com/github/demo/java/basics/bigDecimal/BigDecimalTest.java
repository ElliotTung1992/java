package com.github.demo.java.basics.bigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author 董感恩
 * @date 2020-03-03 13:14
 * @desc
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("800");
        BigDecimal divide = amount.divide(new BigDecimal(3), 4, RoundingMode.HALF_UP);
        System.out.println(divide);

        BigDecimal bigDecimal = new BigDecimal("0.0001").setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal.toString());
    }
}
