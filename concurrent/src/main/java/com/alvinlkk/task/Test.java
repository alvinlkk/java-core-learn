/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk.task;

import java.util.concurrent.TimeUnit;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/5/24
 * @since 1.0
 **/
public class Test {

    public static void main(String[] args) {
        final TimeWheel wheel = new TimeWheel(1, TimeUnit.SECONDS);
        wheel.createTimerTask(new TimerTask() {
            @Override
            public void run() {
                System.out.println(1111);
                //wheel.createTimerTask(this, 4, TimeUnit.SECONDS);
            }
        }, 3,TimeUnit.SECONDS);
    }
}