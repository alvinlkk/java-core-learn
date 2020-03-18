package com.alvinlkk.concurrent.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueue 特性
 * 1. SynchronousQueue没有容量， 每一个put操作需要等待一个get操作，在线程池中用到
 *
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-09-04 12:58
 */
public class SynchronousQueueTest {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        Thread putThread = new Thread(() -> {
            System.out.println("put thread start");
            try {
                queue.put("alvin");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("put thread end");
        });

        Thread getThread = new Thread(() -> {
            System.out.println("get thread start");
            try {
                System.out.println("take: " + queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("get thread end");
        });

        getThread.start();
        Thread.sleep(3000);
        putThread.start();
    }

}
