package com.alvinlkk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * LongAccumulator test
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-08-22 23:02
 */
public class LongAccumulatorTest {

    public static void main(String[] args) {
        LongAccumulator longAccumulator = new LongAccumulator(Long::sum, 0);

        ExecutorService pool = Executors.newCachedThreadPool();

        for(int i =0; i< 1000; i ++) {
            pool.submit(() -> {
                longAccumulator.accumulate(1);
            });
        }
        pool.shutdown();
        while (!pool.isTerminated()) {
        }
        System.out.println(longAccumulator.get());
    }
}
