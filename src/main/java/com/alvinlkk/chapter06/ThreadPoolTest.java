package com.alvinlkk.chapter06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import cn.hutool.core.thread.ThreadFactoryBuilder;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-02-28 18:38
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNamePrefix("test-pool-").build();
        /**
         * corePoolSize    线程池核心池的大小
         * maximumPoolSize 线程池中允许的最大线程数量
         * keepAliveTime   当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间
         * unit            keepAliveTime 的时间单位
         * workQueue       用来储存等待执行任务的队列
         * threadFactory   创建线程的工厂类
         * handler         拒绝策略类,当线程池数量达到上线并且workQueue队列长度达到上限时就需要对到来的任务做拒绝处理
         */
        ExecutorService service = new ThreadPoolExecutor(
                4,
                40,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
