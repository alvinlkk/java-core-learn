package com.alvinlkk.concurrent.pools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-09-05 00:15
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));

        for(int i=0; i < 20; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println(threadPoolExecutor.getActiveCount());
    }
}
