/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/8/24
 * @since 1.0
 **/
public class StackTest {

    @Test
    public void testStack() {
        Stack<String> stack = new Stack<>();
        stack.push("alvin");
        stack.push("cxw1");
        stack.push("cxw2");
        stack.push("cxw");
        stack.push("kk");

        String peek = stack.peek();
        Assert.assertEquals(peek, "kk");

        String pop = stack.pop();
        Assert.assertEquals(pop, "kk");

        int index = stack.search("cxw");
        Assert.assertEquals(index, 1);
    }
}
