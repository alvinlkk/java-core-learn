package com.alvinlkk.proxy;

import java.lang.reflect.Proxy;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-09-04 23:48
 */
public class ProxyTest {

    public static void main(String[] args) {
        TechBook book = new TechBook();
        BookHandler bookHandler = new BookHandler(book);

        BookInterface proxyObj = (BookInterface)Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{BookInterface.class}, bookHandler);

        proxyObj.read();

        proxyObj.write("so hard......");

    }
}
