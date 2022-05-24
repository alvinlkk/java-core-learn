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
public class SychronizedTest3 {
    public static void main(String[] args) {
        Number3 n1 = new Number3();
        Number3 n2 = new Number3();
        new Thread(() -> {
            n1.a();
        }).start();
        new Thread(() -> {
            n2.b();
        }).start();
    }
}

@Slf4j
class Number3 {
    @SneakyThrows
    public synchronized void a() {
        log.debug("a start......");
        Thread.sleep(1000);
        log.debug("a end......");
    }

    @SneakyThrows
    public synchronized void b() {
        log.debug("b start......");
        Thread.sleep(1000);
        log.debug("b end......");
    }
}
