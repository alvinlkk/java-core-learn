/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/9/10
 * @since 1.0
 **/
public class IdentityHashMapTest {
    public static void main(String[] args) {
        // hashMap
        Map<Integer, String> hashMap = new HashMap<>();
        // identityHashMap
        Map<Integer, String> identityHashMap = new IdentityHashMap<>();

        hashMap.put(new Integer(200), "a");
        hashMap.put(new Integer(200), "b");
        identityHashMap.put(new Integer(200), "a");
        identityHashMap.put(new Integer(200), "b");

        //遍历hashmap
        System.out.println("hashmap 结果：");
        hashMap.forEach((key, value) -> {
            System.out.println("key = " + key + ", value = " + value);
        });

        //遍历hashmap
        System.out.println("identityHashMap 结果：");
        identityHashMap.forEach((key, value) -> {
            System.out.println("key = " + key + ", value = " + value);
        });

    }
}
