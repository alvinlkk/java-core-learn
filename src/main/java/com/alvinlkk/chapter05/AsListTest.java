package com.alvinlkk.chapter05;

import java.util.Arrays;
import java.util.List;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-02-28 18:30
 */
public class AsListTest {

    public static void main(String[] args) {

        /**
         * 8. 【强制】使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方 法，
         * 它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
         */

        String[] arr = {"a", "b"};
        List<String> strings = Arrays.asList(arr);
        strings.add("c");
    }
}
