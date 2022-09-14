/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/8/27
 * @since 1.0
 **/
public class LinkedHashTest {

    @Test
    public void test1() {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(5);
        set.add(4);
        set.add(5);
        set.add(3);
        set.add(1);
        set.add(9);
        //正顺序遍历
        System.out.print("遍历：");
        set.forEach(item -> {
            System.out.print(item + "  ");
        });
    }


    @Test
    public void test2() {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(null);
        set.add(5);
        System.out.println(set);
    }

}
