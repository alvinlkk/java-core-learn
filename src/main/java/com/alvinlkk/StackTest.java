package com.alvinlkk;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-09-19 16:01
 */
public class StackTest {
    Stack<String> stack = new Stack<>();

    @Test
    public void testAdd() {
        stack.push("alvin");

        Assert.assertEquals("alvin", stack.peek());
    }

    @Test
    public void testPop() {
        String pop = stack.pop();
        Assert.assertEquals("alvin", pop);
    }

    @Test
    public void testSearch() {
        stack = new Stack<>();
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        stack.push("ddd");
        int ccc = stack.search("aaa");
        System.out.println(ccc);

    }
}
