package com.alvinlkk.proxy;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-09-04 23:50
 */
public class TechBook implements BookInterface {

    @Override
    public void read() {
        System.out.println("reading");
    }

    @Override
    public void write(String words) {
        System.out.println("write" + words);
    }
}
