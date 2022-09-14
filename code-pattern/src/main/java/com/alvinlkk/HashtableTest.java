/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.HashMap;
import java.util.Hashtable;

import org.junit.Test;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/9/13
 * @since 1.0
 **/
public class HashtableTest {

    @Test
    public void test() {
        Hashtable<String, String> table=new Hashtable<>();
        Hashtable<String, String> table1=new Hashtable<>(16);
        Hashtable<String, String> table2=new Hashtable<>(16, 0.75f);
        table.put("T1", "1");
        table.put("T2", "2");
        System.out.println(table);
        // 报空指针异常
        table.put(null, "3");
    }
}
