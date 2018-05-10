package com.github.demo.java.thread.part1;

public class Test10 {

    public static void main(String[] args) {
        Demo a = new Demo("a");
        Demo b = new Demo("b");
        Demo c = new Demo("c");
        Thread10 threadAA = new Thread10("A", c, a);
        Thread10 threadBB = new Thread10("B", a, b);
        Thread10 threadCC = new Thread10("C", b, c);

        Thread threadA = new Thread(threadAA);
        Thread threadB = new Thread(threadBB);
        Thread threadC = new Thread(threadCC);

        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class Demo{
    String name;

    public Demo(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Thread10 implements Runnable{

    String name;
    Demo pre;
    Demo self;

    public Thread10(String name, Demo pre, Demo self){
        this.name = name;
        this.pre = pre;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0){
            synchronized (pre){
                System.out.println(name + "-" + pre.getName() + "锁");
                synchronized (self){
                    System.out.println(name + "-" + self.getName() + "锁");
                    self.notify();
                    System.out.println(name + "-" + self.getName() + "放");
                    count--;
                }
                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
