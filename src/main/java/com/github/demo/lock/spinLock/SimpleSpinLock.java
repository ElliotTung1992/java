package com.github.demo.lock.spinLock;

import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author 董感恩
 * @date 2020-07-15 11:29
 * @desc 可重入自旋锁
 */
@NoArgsConstructor
public class SimpleSpinLock implements Lock {

    //使用线程本身作为同步状态
    private AtomicReference<Thread> owner = new AtomicReference();

    //线程的可重入计数，不需要是可变的
    private Integer count = 0;

    @Override
    public void lock() {
        System.out.println("lock");
        Thread t = Thread.currentThread();
        //如果重新输入，则增加计数
        if(t == owner.get()){
            count++;
            return;
        }
        //spin
        while (!owner.compareAndSet(null, t)){
            System.out.println("lock: " + owner.get());
        }
    }

    @Override
    public void unlock() {
        //只有锁拥有者才能开锁
        Thread t = Thread.currentThread();
        if(t == owner.get()){
            if(count > 0){
                //可重入计数不为零，只需减少计数器
                count--;
            }else{
                //这里不需要比较集，已经检查过了
                owner.set(null);
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }


    public static void main(String[] args) {
        SimpleSpinLock simpleSpinLock = new SimpleSpinLock();
        new Thread(() -> {
            simpleSpinLock.lock();
            simpleSpinLock.lock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            simpleSpinLock.unlock();
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            simpleSpinLock.lock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            simpleSpinLock.unlock();
        }).start();
    }
}
