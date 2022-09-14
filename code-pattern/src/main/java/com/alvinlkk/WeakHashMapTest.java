/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/9/10
 * @since 1.0
 **/
public class WeakHashMapTest {

    public static void main(String[] args) {
        String a = new String("a");
        String b = new String("b");
        Map weakmap = new WeakHashMap();
        weakmap.put(a, "aaa");
        weakmap.put(b, "bbb");
        a = null;
        b = null;
        // 进行gc
        System.gc();
        Iterator j = weakmap.entrySet().iterator();
        while (j.hasNext()) {
            Map.Entry en = (Map.Entry) j.next();
            System.out.println("weakmap:" + en.getKey() + ":" + en.getValue());
        }
    }


}
