package com.alvinlkk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-09-04 23:51
 */
public class BookHandler implements InvocationHandler {

    private Object target;

    public BookHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //System.out.println(target);

        //System.out.println(proxy);

        System.out.println(method.getName());
        if(args != null) {
            for (Object arg : args) {
                System.out.println("arg:" + arg);
            }
        }
        System.out.println("before ----");
        Object result = method.invoke(target, args);
        System.out.println("after ----");
        return result;
    }
}
