/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/9/10
 * @since 1.0
 **/
public class TreeHashMapTest {

    @Test
    public void test1() {
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(16, "a");
        treeMap.put(1, "b");
        treeMap.put(4, "c");
        treeMap.put(3, "d");
        treeMap.put(8, "e");
        // 遍历
        System.out.println("默认排序：");
        treeMap.forEach((key, value) -> {
            System.out.println("key: " + key + ", value: " + value);
        });

        // 构造方法传入比较器
        Map<Integer, String> tree2Map = new TreeMap<>((o1, o2) -> o2 - o1);
        tree2Map.put(16, "a");
        tree2Map.put(1, "b");
        tree2Map.put(4, "c");
        tree2Map.put(3, "d");
        tree2Map.put(8, "e");
        // 遍历
        System.out.println("倒序排序：");
        tree2Map.forEach((key, value) -> {
            System.out.println("key: " + key + ", value: " + value);
        });
    }

    @Test
    public void test2() {
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(null, "a");
    }

    @Test
    public void test3() {
        NavigableMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(16, "a");
        treeMap.put(1, "b");
        treeMap.put(4, "c");
        treeMap.put(3, "d");
        treeMap.put(8, "e");

        // 获取大于等于5的key
        Integer ceilingKey = treeMap.ceilingKey(5);
        System.out.println("ceilingKey 5 is " + ceilingKey);

        // 获取最大的key
        Integer lastKey = treeMap.lastKey();
        System.out.println("lastKey is " + lastKey);
    }

    @Test
    public void test4() {
        TreeMap<Integer, User> treeMap = new TreeMap<>();
        treeMap.put(1, new User("alvin"));
        TreeMap<Integer, User> cloneUser = (TreeMap<Integer, User>)treeMap.clone();
        User user1 = cloneUser.get(1);
        user1.setUsername("cxw");
        System.out.println(user1);

        User user = treeMap.get(1);
        System.out.println(user);
    }

    @Data
    @AllArgsConstructor
    class User {
        private String username;
    }
}
