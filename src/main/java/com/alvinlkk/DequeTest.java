package com.alvinlkk;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-09-22 13:30
 */
public class DequeTest {

    private Deque<String> deque = new ArrayDeque<>();

    @Test
    public void addTest() {
        deque.addFirst("alvin");
        deque.offerFirst("alvin1");
        deque.addFirst("good");
        deque.offerFirst("good1");
        deque.addLast("sss");
        deque.offerLast("sss1");

        String first = deque.peekFirst();
        System.out.println(first);

        String last = deque.peekLast();
        System.out.println(last);
    }
}
