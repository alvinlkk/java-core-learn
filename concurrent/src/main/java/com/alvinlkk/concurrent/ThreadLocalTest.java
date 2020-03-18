package com.alvinlkk.concurrent;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 线程局部变量
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-08-22 23:20
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        System.out.println(ThreadLocalRandom.current().nextInt(10000));
    }
}
