package com.github.demo.lock.spinLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author 董感恩
 * @date 2020-07-17 14:19
 * @desc
 */
public class TicketLock implements Lock {

    private AtomicInteger serviceNum = new AtomicInteger(0);
    private AtomicInteger ticketNum = new AtomicInteger(0);
    private final ThreadLocal<Integer> myNum = new ThreadLocal<>();

    @Override
    public void lock() {
        myNum.set(ticketNum.getAndIncrement());
        while (serviceNum.get() != myNum.get()) {
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
    public void unlock() {
        serviceNum.compareAndSet(myNum.get(), myNum.get() + 1);
        myNum.remove();
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public static void main(String[] args) {

    }
}
