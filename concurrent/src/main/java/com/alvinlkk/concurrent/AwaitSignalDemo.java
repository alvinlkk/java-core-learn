package com.alvinlkk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * await signal demo
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-08-19 23:31
 */
public class AwaitSignalDemo {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try {
            System.out.println("before");
            condition.signal();
        } finally {
            lock.unlock();
        }

    }

    public synchronized void after() {
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalDemo waitNotifyDemo = new AwaitSignalDemo();
        executorService.submit(() -> waitNotifyDemo.after());
        executorService.submit(() -> waitNotifyDemo.before());
    }
}
