package com.github.demo.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 董感恩
 * @date 2020-08-06 16:09
 * @desc 研究一下线程安全的list
 *
 *  1. SynchronizedList
 *  2. CopyOnWriteArrayList
 *
 *     SynchronizedList是线程安全的
 *     几乎所有的方法都加上了同步代码块
 *     但是如果你需要对集合集合进行便利
 *     则需要在遍历集合的时候加上同步代码块
 *     因为返回迭代器的方法没有加同步
 *
 *     SynchronizedList在获取集合元素的方法
 *     上也加了同步代码块
 *
 *     CopyOnWriteArrayList也是线程安全的
 *     CopyOnWriteArrayList只有修改元素的方法上
 *     加了同步代码块，获取元素的方法没有添加同步代码块
 *     他是通过复制集合来规避在获取时发生修改会报错的问题
 *     但是代价也是非常高的，这会消耗大量的内存
 *     但是这是目前最好的方案
 *
 *   对比：
 *     CopyOnWriteArrayList适合用于读多写少的场景
 *     SynchronizedList适合于增删改多读少的场景
 *
 */
public class SynchronizedList {

    static List commonList = new ArrayList();

    static List list = new ArrayList();
    static List synchronizedList = Collections.synchronizedList(list);

    static CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

    public static void main(String[] args) throws Exception {
        //testOne();
        //testTwo();
        //testThree();
        //testFour();
        testFive();
    }

    //模拟synchronizedList在遍历的时候，修改集合的场景：
    private static void testFive() {
        synchronizedList.add("a");
        synchronizedList.add("b");
        synchronizedList.add("c");
        synchronizedList.add("d");

        Runnable runnable = () -> {
            synchronized (synchronizedList) {
                Iterator iterator = synchronizedList.iterator();
                while (iterator.hasNext()){
                    System.out.println(iterator.next());
                    try {
                        Thread.sleep(2000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("====");
            synchronizedList.remove("c");
            System.out.println("====");
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (synchronizedList) {
                Iterator iterator = synchronizedList.iterator();
                while (iterator.hasNext()){
                    System.out.println("=" + iterator.next());
                }

            }
        };

        new Thread(runnable).start();
        new Thread(runnable2).start();
    }

    //模拟CopyOnWriteArrayList在遍历的时候，修改集合的场景：
    private static void testFour() {
        copyOnWriteArrayList.add("a");
        copyOnWriteArrayList.add("b");
        copyOnWriteArrayList.add("c");
        copyOnWriteArrayList.add("d");

        Runnable runnable = () -> {
            Iterator iterator = copyOnWriteArrayList.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
                try {
                    Thread.sleep(2000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            copyOnWriteArrayList.remove("c");
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Iterator iterator = copyOnWriteArrayList.iterator();
            while (iterator.hasNext()){
                System.out.println("=" + iterator.next());
            }
        };

        new Thread(runnable).start();
        new Thread(runnable2).start();
    }

    /**
     * @author 董感恩
     * @date 2020-08-06 16:52:23
     * @desc 模拟List在多线程环境下的问题
     *          1. 报ArrayIndexOutOfBoundsException异常
     *          2. List的size小于2000
     **/
    public static void testTwo() throws InterruptedException {

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                commonList.add(i);
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(commonList.size());
    }

    private static void testOne() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 7000000; i++) {
                commonList.add(i);
            }
        };
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        System.out.println(System.currentTimeMillis() - start);
        thread1.join();
        thread2.join();

        System.out.println(commonList.size());
        System.out.println("========");

        Runnable runnable2 = () -> {
            for (int i = 0; i < 7000000; i++) {
                synchronizedList.add(i);
            }
        };

        long start2 = System.currentTimeMillis();
        Thread thread3 = new Thread(runnable2);
        Thread thread4 = new Thread(runnable2);
        thread3.start();
        thread4.start();
        System.out.println(System.currentTimeMillis() - start2);
        thread3.join();
        thread4.join();

        System.out.println(synchronizedList.size());
        System.out.println("========");
    }

    private static void testThree() {
        synchronizedList.add(1);
        synchronizedList.add(2);
        synchronizedList.add(3);
        synchronizedList.add(4);
        synchronizedList.add(5);

        synchronizedList.remove(0);
        synchronizedList.add(6);

        synchronizedList.remove(0);
        synchronizedList.add(7);

        synchronizedList.stream().forEach(System.out::println);

        System.out.println(synchronizedList.contains(8));
    }
}
