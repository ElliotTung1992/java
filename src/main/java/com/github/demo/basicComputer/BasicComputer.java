package com.github.demo.basicComputer;

/**
 * @author 董感恩
 * @date 2020-08-12 13:58
 * @desc 计算机基础运算
 */
public class BasicComputer {

    public static void main(String[] args) {
        //testComplement();
        //symbolicOperationNot();
        symbolicOperationOr();
    }

    /**
     * @author 董感恩
     * @date 2020-08-12 14:45:26
     * @desc 符号运算
     *
     *  1. |或算符
     *  按位或(OR)操作,1和1取1，1和0取1，0和0取0
     **/
    private static void symbolicOperationOr() {
        int i = 3 | 5;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));

        // 3的原码: 00000000 00000000 00000000 00000011
        // 5的原码: 00000000 00000000 00000000 00000101
        //         00000000 00000000 00000000 00000111 = 7
    }

    /**
     * @author 董感恩
     * @date 2020-08-12 14:45:26
     * @desc 符号运算
     *
     *  1. ~元算符
     *  按位非(NOT)操作,每位取反,原来的1取0，0取1
     **/
    private static void symbolicOperationNot() {
        System.out.println(1);
        System.out.println(~1);
        //   1的源码: 00000000 00000000 00000000 000000001
        // 取反(补码): 11111111 11111111 11111111 11111110
        //      反码: 11111111 11111111 11111111 11111101
        //      原码: 10000000 00000000 00000000 00000010 = -2
    }

    /**
     * @author 董感恩
     * @date 2020-08-12 13:59:07
     * @desc 补码
     *
     *  1. 补码
     *  正数的补码是原码本身
     *  负数的补码是其原码的基础上，符号位不变，取反后加1
     *
     *  2. 补码的意义
     *  统一计算机的加减
     *
     **/
    private static void testComplement() {
        int i = 7 + (-7);
        System.out.println(i);
        //  7的原码: 00000000 00000000 00000000 00000111
        //
        // -7的原码: 10000000 00000000 00000000 00000111
        // -7的反码: 11111111 11111111 11111111 11111000
        // -7的补码: 11111111 11111111 11111111 11111001
        //
        //   00000000 00000000 00000000 00000111
        //  +11111111 11111111 11111111 11111001
        //   10000000 00000000 00000000 00000000 = 0

        int j = 3 + (-4);
        System.out.println(j);
        //  3的原码: 00000000 00000000 00000000 00000011
        //
        // -4的原码: 10000000 00000000 00000000 00000100
        // -4的反码: 11111111 11111111 11111111 11111011
        // -4的补码: 11111111 11111111 11111111 11111100
        //
        //   00000000 00000000 00000000 00000011
        //  +11111111 11111111 11111111 11111100
        //   11111111 11111111 11111111 11111111

        // 补码: 11111111 11111111 11111111 11111111
        // 反码: 11111111 11111111 11111111 11111110
        // 原码: 10000000 00000000 00000000 00000001 = -1
    }
}
