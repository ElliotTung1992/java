package com.github.demo.java7.other;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) throws IOException {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }

    private static String test5() throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(""))){
            return bufferedReader.readLine();
        }
    }

    private static String test4() throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(""));
            return bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                bufferedReader.close();
            }
        }
        return null;
    }

    private static void test3() {
        try {
            Thread.sleep(1000);
            Class.forName("com.mysql.jdbc.Driver");
        } catch (InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        byte b1 = 33;       //十进制
        byte b2 = 0x21;     //十六进制
        byte b3 = 0b00100001; //二进制

        System.out.println(b1 == b2);
        System.out.println(b2 == b3);
    }

    private static void test1() {
        List<String> list = new ArrayList<>();
        List<String> listString = new ArrayList<String>();
    }


}
