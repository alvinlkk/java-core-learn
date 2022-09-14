/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/8/20
 * @since 1.0
 **/
public class ArrayListTest {

    public static void main(String[] args) {
        // 创建容器，最好传入容器预估的大小
        List<String> usernames = new ArrayList<>(16);

        // 添加元素
        usernames.add("alvin");
        usernames.add("cxw");
        usernames.add("kk");
        usernames.add("alvin");
        usernames.add("lucy");
        usernames.add("cc");
        usernames.add("alvin");

        // 修改元素
        usernames.set(5, "tt");

        //查看元素
        System.out.println(usernames.get(5));

        // 删除元素
        usernames.remove("alvin");
        // cxw, kk, alvin, lucy, tt, alvin
        System.out.println(usernames);

        List<String> deleteUserNames = new ArrayList<>(1);
        deleteUserNames.add("alvin");
        // [cxw, kk, lucy, tt]
        usernames.removeAll(deleteUserNames);
        System.out.println(usernames);

        // 遍历删除的正确姿势
        Iterator<String> iterator = usernames.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("alvin".equals(item)) {
                iterator.remove();
            }
        }

        //使用Lambda表达式使用每个字符的长度替代原集合的元素
        usernames.replaceAll(ele -> ele + " NB");
        System.out.println(usernames);

        // 并发遍历，具体去学习下分割器
        usernames.spliterator().forEachRemaining(item -> System.out.println(item));
    }
}
