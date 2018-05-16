package com.github.demo.java7.suppress_exception;

public class Test2 {

    public static void main(String[] args) throws BaseException2 {
        read("");
    }

    private static void read(String filename) throws BaseException2 {
//        FileInputStream fileInputStream = null;
//        Exception exception = null;
//        try {
//            fileInputStream = new FileInputStream(filename);
//        } catch (FileNotFoundException e) {
//            exception = e;
//        } finally {
//            if(fileInputStream != null){
//                try {
//                    fileInputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    if(exception == null){
//                        exception = e;
//                    }
//                }
//            }
//            if(exception != null){
//                throw new BaseException2(exception);
//            }
//        }
        Exception exception = null;
        try {
            Integer.parseInt("hello");
        } catch (NumberFormatException e1){
            exception = e1;
        } finally {
            try {
                int i = 1 / 0;
            }catch (ArithmeticException e2){
                if(exception == null){
                    exception = e2;
                }
            }
            if(exception != null){
                throw new BaseException2(exception);
            }
        }
    }
}

class BaseException2 extends Exception {
    private static final long serialVersionUID = 5062456327806414216L;
    public BaseException2(Exception ex){
        super(ex);
    }
}


