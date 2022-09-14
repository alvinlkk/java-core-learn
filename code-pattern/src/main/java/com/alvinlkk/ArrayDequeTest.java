/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/8/28
 * @since 1.0
 **/
public class ArrayDequeTest {

    @Test
    public void test1() {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("1");
        deque.offer("2");
        deque.offerLast("3");
        System.out.println(deque);
        String poll = deque.poll();
        System.out.println(poll);
        System.out.println(deque);
    }

    @Test
    public void test2() {
        Deque<String> deque = new ArrayDeque<>();
        deque.push("1");
        deque.push("2");
        deque.push("3");
        String pop = deque.pop();
        System.out.println(pop);
    }

    @Test
    public void test3() {
        Deque<String> deque = new ArrayDeque<>();
        boolean offerResult = deque.offer(null);
        System.out.println(offerResult);
        System.out.println(deque);
    }

    @Test
    public void test4() {
        Deque<String> deque = new ArrayDeque<>();
        String poll = deque.poll();
        //取出为null
        System.out.println(poll);

        // 因为容量为空了，会抛出异常
        String remove = deque.remove();
        System.out.println(remove);
        System.out.println(deque);
    }

    @Test
    public void test5() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("a");
    }
}
