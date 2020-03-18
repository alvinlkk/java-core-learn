package com.alvinlkk.concurrent.threads;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 可完成future
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-08-25 23:07
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        whenComplete();

    }

    public static void whenComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if(new Random().nextInt()%2>=0) {
                int i = 12/0;
            }
            System.out.println("run end ...");
        }).whenComplete((t, action) -> {
            System.out.println("执行完成");
        }).exceptionally((t) -> {
            System.out.println("执行失败！"+t.getMessage());
            return null;
        });

        future.get();
    }
}
