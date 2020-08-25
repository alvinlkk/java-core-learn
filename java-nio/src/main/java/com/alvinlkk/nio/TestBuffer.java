package com.alvinlkk.nio;

import java.nio.ByteBuffer;

import org.junit.Test;

/**
 *
 * 四、缓存区中四个核心的属性
 * capacity: 容量， 表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 * limit:
 * postion:
 * mark:n
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-04-29 10:32
 */
public class TestBuffer {

    @Test
    public void test1() {
        String str = "alvin";

        // 分配一个指定大小的缓存区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());

        System.out.println("buffer postion: " + buffer.position());
        System.out.println("buffer limit: " + buffer.limit());
        System.out.println("buffer capacity: " + buffer.capacity());


        buffer.flip();

        System.out.println("buffer postion: " + buffer.position());
        System.out.println("buffer limit: " + buffer.limit());
        System.out.println("buffer capacity: " + buffer.capacity());

        byte[] res = new byte[buffer.limit()];
        buffer.get(res);
        System.out.println(new String(res));

        buffer.rewind();

        System.out.println("buffer postion: " + buffer.position());
        System.out.println("buffer limit: " + buffer.limit());
        System.out.println("buffer capacity: " + buffer.capacity());

        System.out.println("ssss");
    }

    @Test
    public void test2() {

    }

}
