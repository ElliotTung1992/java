package com.github.demo.java.thread.part2;


import java.util.*;

/**
 * 模拟多线程出错
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {
        Store store = new Store();
        Consumer consumer1 = new Consumer(store);
        Consumer consumer2 = new Consumer(store);
        Consumer consumer3 = new Consumer(store);
//        Consumer consumer4 = new Consumer(store);

        Thread thread2 = new Thread(consumer1);
        Thread thread3 = new Thread(consumer2);
        Thread thread4 = new Thread(consumer3);
//        Thread thread5 = new Thread(consumer4);

        thread2.start();
        thread3.start();
        thread4.start();
//        thread5.start();
    }

}

//仓库
class Store{

    List<Integer> list = new ArrayList<>();
    int j = 0;
    int k = 0;

    int i = 100;

    //取
    public void pop() throws InterruptedException {
        if(i > 0){
            Thread.sleep(100);
            i --;
            list.add(i);
            j = j + 1;
            k++;
        }else {
            System.out.println("set.size:" + list.size());
            System.out.println("j:" + j);
            System.out.println("k:" + k);

            System.out.println("-------------");
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()){
                Integer next = iterator.next();
                System.out.println(next);
            }
            System.out.println("--------------");
            Thread.sleep(10000);
        }

    }

}

//消费者
class Consumer implements Runnable{

    Store store;
    public Consumer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        while (true){
            try {
                store.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
