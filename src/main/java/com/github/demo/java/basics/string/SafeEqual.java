package com.github.demo.java.basics.string;

/**
 * @author 董感恩
 * @date 2020-07-06 21:32
 * @desc 字符串比较防止计时攻击
 */
public class SafeEqual {

    public static boolean safeEqual(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        int isEqual = 0;
        for (int i = 0; i < str1.length(); i++) {
            isEqual |= str1.charAt(i) ^ str2.charAt(i);
        }
        return isEqual == 0;
    }

    public static void main(String[] args) {
        char a = 3;//011
        char b = 4;//100
        System.out.println(a ^ b);

        int c = 0;
        char d = 3;
        c |= d;
        System.out.println(c);

        System.out.println(safeEqual("abc", "abc"));
        System.out.println(safeEqual("abc", "abf"));
    }
}
