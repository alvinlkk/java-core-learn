package com.alvinlkk.concurrent.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 测试callable
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-08-25 22:56
 */
public class CallableTest {

    class SumCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for(int i =0; i < 1000; i ++) {
                Thread.sleep(20);
                sum += i;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumCallable sumCallable = new CallableTest().new SumCallable();
        FutureTask<Integer> sumTask = new FutureTask<>(sumCallable);
        Thread sumThread = new Thread(sumTask);
        System.out.println("task run start ---");
        sumThread.start();
        //get 方法阻塞
        Integer sum = sumTask.get();
        System.out.println("task result: " + sum);
        System.out.println("task run end ---");
    }

}
