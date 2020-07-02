package com.github.demo.java.basics.float_test;

import java.math.BigDecimal;

/**
 * @author 董感恩
 * @date 2020-07-02 14:12
 * @desc
 */
public class FloatTest {

    public static void main(String[] args) {
        test1();
    }

    //为什么金额计算不能咏float
    private static void test1() {
        float f1 = 6.6f;
        float f2 = 1.3f;
        //7.8999996
        System.out.println(f1 + f2);

        //计算机只能识别0和1

        //float总共占用32位
        //符号位（1）指数部分（8）有效部分（23）

        //二进制的转换
        //整数部分的计算 6（110）
        //小数部分的计算 0.6 (10011...)
        // [将小数乘以2，取整数部分作为二进制的值，然后再将小数乘以2，再取整数部分，以此往复循环。]

        //规约化
        //相当于科学计数法 110.10011001规约化为：1.1010011001*2^2

        //指数偏移值
        //指数偏移值 = 固定值 + 规约化的指数值
        //float为8位。所以float中固定值为127
        //6.6的二进制值规约化以后为1.1010011001*2^2，指数是2，
        //所以偏移值就是127+2=129，转换为二进制就是10000001

        //拼接6.6
        //6.6为正数，符号位为0，指数部分为偏移值的二进制10000001，
        //有效部分为规约形式的小数部分，取小数的前23位即10100110011001100110011
        //最后拼接到一起即 01000000110100110011001100110011

        //解决方案,空间和时间开销大
        long start = System.currentTimeMillis();
        BigDecimal b1 = new BigDecimal(6.6);
        BigDecimal b2 = new BigDecimal(1.3);
        BigDecimal add = b1.add(b2);
        float v = add.floatValue();
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start);

        //优化方案
        long start2 = System.currentTimeMillis();
        Integer i1 = 660;
        Integer i2 = 130;
        float f3 = (float) (i1 + i2) / 100;
        System.out.println(f3);
        System.out.println(System.currentTimeMillis() - start2);
    }
}
