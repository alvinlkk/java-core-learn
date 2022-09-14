/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/8/27
 * @since 1.0
 **/
public class TreeSetTest {

    @Test
    public void test1() {
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(4);
        set.add(5);
        set.add(3);
        set.add(1);
        set.add(9);
        //正顺序遍历
        System.out.print("正序遍历：");
        set.forEach(item -> {
            System.out.print(item + "  ");
        });
        System.out.println();

        //逆序遍历
        System.out.print("逆序遍历：");
        set.descendingIterator().forEachRemaining(item -> {
            System.out.print(item + "  ");
        });
    }

    @Test
    public void test2() {
        // 自定义排序器
        NavigableSet<Integer> set = new TreeSet<>((o1, o2) -> o2 - o1);
        set.add(5);
        set.add(4);
        set.add(5);
        set.add(3);
        set.add(1);
        set.add(9);
        //正顺序遍历
        System.out.print("正序遍历：");
        set.forEach(item -> {
            System.out.print(item + "  ");
        });
        System.out.println();
    }

    @Test
    public void test3() {
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(null);
    }

    @Test
    public void test4() {

        String val;

        // 新建TreeSet
        TreeSet tSet = new TreeSet();
        // 将元素添加到TreeSet中
        tSet.add("aaa");
        // Set中不允许重复元素，所以只会保存一个“aaa”
        tSet.add("aaa");
        tSet.add("bbb");
        tSet.add("eee");
        tSet.add("ddd");
        tSet.add("ccc");
        System.out.println("TreeSet:" + tSet);

        // 打印TreeSet的实际大小
        System.out.printf("size : %d\n", tSet.size());

        // 导航方法
        // floor(小于、等于)
        System.out.printf("floor bbb: %s\n", tSet.floor("bbb"));
        // lower(小于)
        System.out.printf("lower bbb: %s\n", tSet.lower("bbb"));
        // ceiling(大于、等于)
        System.out.printf("ceiling bbb: %s\n", tSet.ceiling("bbb"));
        // higher(大于)
        System.out.printf("higher bbb: %s\n", tSet.higher("bbb"));
        // subSet()
        System.out.printf("subSet(aaa, true, ccc, true): %s\n", tSet.subSet("aaa", true, "ccc", true));
        System.out.printf("subSet(aaa, true, ccc, false): %s\n", tSet.subSet("aaa", true, "ccc", false));
        System.out.printf("subSet(aaa, false, ccc, true): %s\n", tSet.subSet("aaa", false, "ccc", true));
        System.out.printf("subSet(aaa, false, ccc, false): %s\n", tSet.subSet("aaa", false, "ccc", false));
        // headSet()
        System.out.printf("headSet(ccc, true): %s\n", tSet.headSet("ccc", true));
        System.out.printf("headSet(ccc, false): %s\n", tSet.headSet("ccc", false));
        // tailSet()
        System.out.printf("tailSet(ccc, true): %s\n", tSet.tailSet("ccc", true));
        System.out.printf("tailSet(ccc, false): %s\n", tSet.tailSet("ccc", false));
    }
}
