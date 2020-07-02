package com.github.demo.java.basics.string;

/**
 * String练习
 */
public class StringTest {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = str1;
        String str3 = "abc";
        System.out.println("str1 == str2:" + (str1 == str2));
        System.out.println("str1 == str3:" + (str1 == str3));
        System.out.println("str2 == str3:" + (str3 == str2));
        str1 = "aaa";
        System.out.println("str1 == str2:" + (str1 == str2));
        System.out.println("str1 == str3:" + (str1 == str3));
        System.out.println("str2 == str3:" + (str3 == str2));
        str1 = "abc";
        System.out.println("str1 == str2:" + (str1 == str2));
        System.out.println("str1 == str3:" + (str1 == str3));
        System.out.println("str2 == str3:" + (str3 == str2));

        String s1 = new String("abc");
        String s2 = s1;
        String s3 = new String("abc");
        System.out.println("s1 == s2:" + (s1 == s2));
        System.out.println("s1 == s3:" + (s1 == s3));
        System.out.println("s2 == s3:" + (s2 == s3));
        s1 = "abc";
        System.out.println("s1 == s2:" + (s1 == s2));
        System.out.println("s1 == s3:" + (s1 == s3));
        System.out.println("s2 == s3:" + (s2 == s3));


        String str = "提单号:COSU6258116820G,COSU6258116820A,COSU6258116820,COSU6258116820E,COSU6258116820H,COSU6258116820C,COSU6258116820B,COSU6258116820F,COSU6258116820D\r\n船名航次:EVER LUNAR/0461-033E 开航日期:2020-03-09";
        System.out.println(str.length());

    }
}
