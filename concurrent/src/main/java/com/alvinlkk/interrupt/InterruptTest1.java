/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk.interrupt;

import java.util.concurrent.locks.LockSupport;

import lombok.extern.slf4j.Slf4j;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/1/19
 * @since 1.0
 **/
@Slf4j(topic = "a")
public class InterruptTest1 {
    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
        test3();
    }

    private static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("error", e);
            }
        }, "t1");
        t1.start();
        Thread.sleep(500);
        t1.interrupt();
        Thread.sleep(100);
        log.info(" interrupt status : {}", t1.isInterrupted());
    }

    private static void test2() throws InterruptedException {
        Thread t2 = new Thread(() -> {
            while (true) {
                boolean isInterrupted = Thread.currentThread().isInterrupted();
                if (isInterrupted) {
                    log.info("interrupt status: {}", isInterrupted);
                    break;
                }
            }
        }, "t2");
        t2.start();
        Thread.sleep(500);
        t2.interrupt();
        Thread.sleep(100);
        log.info(" thread status, {}, interrupt status : {}", t2.getState(), t2.isInterrupted());
    }

    public static void test3() throws InterruptedException {
        Thread t3 = new Thread(() -> {
            log.debug("t3 park.....");
            LockSupport.park();
            log.debug("t3 unpark.....");
            log.debug("interrupt status: [{}]", Thread.currentThread().isInterrupted());

            log.debug("t3 第二次 park.....");
            LockSupport.park();
            log.debug("t3 中断位为true, park失效.....");
        }, "t3");
        t3.start();

        Thread.sleep(1000);
        t3.interrupt();
    }
}
