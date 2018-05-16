package com.github.demo.java7.suppress_exception;

public class Test1 {

    public static void main(String[] args) throws BaseException {
        show();
    }

    private static void show() throws BaseException {
        try {
            Integer.parseInt("hello");
        } catch (NumberFormatException e1){
            throw new BaseException(e1);
        } finally {
            try {
                int i = 1 / 0;
            }catch (ArithmeticException e2){
                throw new BaseException(e2);
            }
        }

    }

}

class BaseException extends Exception {

    public BaseException(Exception ex){
        super(ex);
    }
    private static final long serialVersionUID = 3987852541476867869L;
}
