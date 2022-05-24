/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2021/9/15
 * @since 1.0
 **/
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.submit(() -> System.out.println("hhh"), "cc");
        executorService.shutdown();
    }
}
