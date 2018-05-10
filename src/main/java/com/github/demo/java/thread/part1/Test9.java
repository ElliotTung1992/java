package com.github.demo.java.thread.part1;

public class Test9 {

    public static void main(String[] args) {

        Test9 test9 = new Test9();

        Thread9 thread9 = test9.new Thread9("A");
        Thread9 thread10 = test9.new Thread9("B");
        thread10.setPriority(1);

        thread9.start();
        thread10.start();
    }

    class Thread9 extends Thread{

        String name;

        public Thread9(String name){
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 50; i++) {
                System.out.println("" + this.getName() + "-----" + i);
                if (i ==30) {
                    this.yield();
                }
            }
        }
    }
}


