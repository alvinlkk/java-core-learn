/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/8/30
 * @since 1.0
 **/
public class Task {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        };

        Runnable runnable2 = () -> System.out.println("runnable");
    }
}
