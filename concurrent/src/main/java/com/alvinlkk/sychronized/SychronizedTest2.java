/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk.sychronized;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/1/24
 * @since 1.0
 **/
public class SychronizedTest2 {
    public static void main(String[] args) {
        Number2 n1 = new Number2();
        new Thread(() -> {
            n1.a();
        }).start();
        new Thread(() -> {
            n1.b();
        }).start();
    }
}

@Slf4j
class Number2 {
    @SneakyThrows
    public synchronized void a() {
        log.debug("a start......");
        Thread.sleep(1000);
        log.debug("a end......");
    }

    @SneakyThrows
    public void b() {
        log.debug("b start......");
        Thread.sleep(1000);
        log.debug("b end......");
    }
}
