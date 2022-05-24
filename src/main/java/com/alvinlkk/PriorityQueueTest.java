package com.alvinlkk;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-09-22 13:16
 */
public class PriorityQueueTest {

    private Queue<Integer> priorityQueue = new PriorityQueue<>();

    @Test
    public void testAdd() {
        priorityQueue.add(5);
        priorityQueue.offer(6);
        priorityQueue.add(12);
        priorityQueue.offer(1);
        priorityQueue.add(18);
        priorityQueue.offer(17);

        Integer peek = priorityQueue.peek();
        System.out.println(peek);

        //和ele的区别是抛出异常
        Integer ele = priorityQueue.element();
        System.out.println(ele);

    }

    @Test
    public void testRemove() {
        priorityQueue.add(5);
        priorityQueue.offer(6);
        priorityQueue.add(12);
        priorityQueue.offer(1);
        priorityQueue.add(18);
        priorityQueue.offer(17);

        Integer poll = priorityQueue.poll();
        System.out.println(poll);
        poll = priorityQueue.remove();
        System.out.println(poll);

    }

}
