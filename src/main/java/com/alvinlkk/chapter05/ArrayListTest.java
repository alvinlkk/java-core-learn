package com.alvinlkk.chapter05;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-02-28 18:16
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(16);
        names.add("ab");
        names.add("abc");
        List<String> newNames = names.subList(0, 1);
        System.out.println(newNames instanceof ArrayList);
        names.add("c");
        //在subList场景中，高度注意对原集合元素的增加或删除，均会导致子列表
        // 的遍 历、增加、删除产生 ConcurrentModificationException 异常。
        newNames.forEach(System.out::println);
    }
}
