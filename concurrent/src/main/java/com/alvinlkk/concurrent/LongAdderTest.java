package com.alvinlkk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * 测试long adder 工具类
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-08-22 22:48
 */
public class LongAdderTest {

    public static void main(String[] args) throws InterruptedException {
        LongAdder adder = new LongAdder();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for(int i =0; i< 100; i ++) {
            pool.submit(() -> {
                adder.increment();
            });
        }
        pool.shutdown();
        while (!pool.isTerminated()) {
        }
        System.out.println(adder.sum());

    }
}
