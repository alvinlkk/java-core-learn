package com.alvinlkk.java8;

import java.util.stream.Stream;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-02-26 11:10
 */
public class StreamApiTest {

    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 1).limit(5).forEach(System.out::println);

        Stream.generate(() -> "Hello Man!").limit(10).forEach(System.out::println);
    }
}
