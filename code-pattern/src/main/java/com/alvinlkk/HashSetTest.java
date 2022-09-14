/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/8/26
 * @since 1.0
 **/
public class HashSetTest {

    @Test
    public void test1() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");
        set.add("c");

        // 添加了4个元素，size = 3
        System.out.println(set.size());
        System.out.println(set);
    }
 }
