/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/8/28
 * @since 1.0
 **/
public class PriorityQueueTest {

    @Test
    public void test1() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(5);
        queue.offer(4);
        queue.offer(1);
        queue.offer(9);
        queue.offer(3);
        queue.offer(2);

        // 打印，排序
        Integer poll = null;
        while ((poll = queue.poll()) != null) {
            System.out.println(poll);
        }
    }

    @Test
    public void test2() {
        // 自定义排序，倒序
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(5);
        queue.offer(4);
        queue.offer(1);
        queue.offer(9);
        queue.offer(3);
        queue.offer(2);

        // 打印，排序
        Integer poll = null;
        while ((poll = queue.poll()) != null) {
            System.out.println(poll);
        }
    }
}
