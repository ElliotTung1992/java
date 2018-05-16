package com.github.demo.java7.try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test1 {

    public static void main(String[] args) throws IOException, BaseException {
        String s = test1();
        System.out.println(s);

        String s2 = test2();
    }

    private static String test2() throws BaseException {
        BufferedReader bufferedReader = null;
        Exception exception = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("E:\\java\\test111.txt"));
            return bufferedReader.readLine();
        } catch (IOException e1) {
            throw new BaseException(e1);
        } finally {
//            if(bufferedReader != null){
                try {
                    int i = 1 / 0;
                    bufferedReader.close();
                } catch (IOException e2) {
                    throw new BaseException(e2);
                }
//            }
        }
    }

    private static String test1() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\java\\test.txt"))) {
            return bufferedReader.readLine();
        }
    }
}

class BaseException extends Exception {

    public BaseException(Exception ex){
        super(ex);
    }
    private static final long serialVersionUID = 3987852541476867869L;
}
