package com.github.demo.java7.suppress_exception;

public class Test3 {

    public static void main(String[] args) throws Exception {
        show();
    }

    private static void show() throws Exception {
        Exception exception = null;
        try {
            Integer.parseInt("hello");
        } catch (NumberFormatException e1){
            exception = e1;
        } finally {
            try {
                int i = 1 / 0;
            }catch (ArithmeticException e2){
                if(exception != null){
                    exception.addSuppressed(e2);
                }
            }
            if(exception != null){
                throw exception;   //注意这里
            }
        }
    }
}

