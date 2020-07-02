package com.github.demo.java.regex;


import java.util.regex.Pattern;

/**
 * @author 董感恩
 * @date 2020-03-02 14:04
 * @desc
 */
public class RegexTest {

    public static final String REGEX_EMAIL = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";

    public static void main(String[] args) {
        boolean email = isEmail("dge_1992@163.com");
        System.out.println(email);
    }

    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }
}
