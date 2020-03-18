package com.alvinlkk.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阻塞队列arrayBlockingQueue例子
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-08-24 15:20
 */
public class ArrayBlockingQueueTest {

    class Producer implements Runnable {

        private BlockingQueue<String> buckets;

        public Producer(BlockingQueue<String> buckets) {
            this.buckets = buckets;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(1000);
                buckets.put("food");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "produce food");

        }
    }

    class Consumer implements Runnable {

        private BlockingQueue<String> buckets;

        public Consumer(BlockingQueue<String> buckets) {
            this.buckets = buckets;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "wait for food");
                String food = buckets.take();
                System.out.println(Thread.currentThread().getName() + "consume food");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        BlockingQueue<String> buckets = new ArrayBlockingQueue<>(2);
        for(int i =0; i<5; i++) {
            executorService.execute(new ArrayBlockingQueueTest().new Producer(buckets));
        }
        for(int i =0; i<2; i++) {
            executorService.execute(new ArrayBlockingQueueTest().new Consumer(buckets));
        }
        executorService.shutdown();
    }
}

