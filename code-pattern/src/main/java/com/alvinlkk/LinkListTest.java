/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/8/22
 * @since 1.0
 **/
public class LinkListTest {

    @Test
    public void testListFunc() {
        List<String> userNames = new LinkedList<>();
        userNames.add("alvin");
        userNames.add("cxw");
        userNames.add("hh");
        userNames.add("ss");

        String username = userNames.get(2);
        Assert.assertEquals("hh", username);
    }

    @Test
    public void testQueueFunc() {
        Deque<String> userNames = new LinkedList<>();
        userNames.offer("alvin");
        userNames.offer("cxw");
        userNames.offer("kk");

        String username = userNames.poll();
        Assert.assertEquals("alvin", username);
    }

    @Test
    public void testStackFunc() {
        Deque<String> userNames = new LinkedList<>();
        userNames.push("alvin");
        userNames.push("cxw");
        userNames.push("kk");

        String username = userNames.peek();
        Assert.assertEquals("kk", username);

        username = userNames.pop();
        Assert.assertEquals("kk", username);
    }
}
