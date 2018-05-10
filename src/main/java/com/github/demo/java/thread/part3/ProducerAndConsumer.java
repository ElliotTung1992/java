package com.github.demo.java.thread.part3;

import java.util.LinkedList;

/**
 * 生产者和消费者模型
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {
        Repertory repertory = new Repertory();

        Producer producer1 = new Producer(repertory);
        Producer producer2 = new Producer(repertory);
        Producer producer3 = new Producer(repertory);
        Producer producer4 = new Producer(repertory);

        Consumer consumer1 = new Consumer(repertory);
        Consumer consumer2 = new Consumer(repertory);

        Thread thread1 = new Thread(producer1, "赵云");
        Thread thread2 = new Thread(producer2, "马超");
        Thread thread3 = new Thread(producer3, "王忠");
        Thread thread6 = new Thread(producer4, "关羽");

        Thread thread4 = new Thread(consumer1, "周瑜");
        Thread thread5 = new Thread(consumer2, "曹超");

//        thread1.setPriority(10);
//        thread2.setPriority(10);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}

//产品类
class Product{
    int id;

    public Product(int id){
        this.id = id;
    }
}

//仓库
class Repertory{
    public LinkedList<Product> store = new LinkedList<>();

    public LinkedList<Product> getStore() {
        return store;
    }

    public void setStore(LinkedList<Product> store) {
        this.store = store;
    }

    //生产者方法
    public synchronized void push(Product p, String threadName){
        while (store.size() == 10){
            try {
                System.out.println(threadName + " 报告:仓库已经满了");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();

        store.addLast(p);

        System.out.println(threadName + " 生产了一个商品，仓库总数：" + store.size());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //消费者方法
    public synchronized void pop(String threadName){

        while (store.size() == 0){
            try {
                System.out.println(threadName + " 报告：仓库没货啦");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.notifyAll();
        store.removeFirst();
        System.out.println(threadName + "消费了一个商品，当前仓库存量：" + store.size());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//生产者
class Producer implements Runnable{

    public static int i = 0;

    Repertory repertory = null;

    public Producer(Repertory repertory){
        this.repertory = repertory;
    }

    @Override
    public void run() {
        while (true){
            synchronized (Producer.class){
                i ++;
                Product product = new Product(i);
                repertory.push(product, Thread.currentThread().getName());
            }
        }
    }
}

//消费者
class Consumer implements Runnable{

    Repertory repertory = null;
    public Consumer(Repertory repertory){
        this.repertory = repertory;
    }


    @Override
    public void run() {
        while (true){
            repertory.pop(Thread.currentThread().getName());
        }
    }
}