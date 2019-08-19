package com.alvinlkk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * wait notify demo
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-08-19 23:31
 */
public class WaitNotifyDemo {

    public synchronized void before() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyDemo waitNotifyDemo = new WaitNotifyDemo();
        executorService.submit(() -> waitNotifyDemo.after());
        executorService.submit(() -> waitNotifyDemo.before());
    }
}
