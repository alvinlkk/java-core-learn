package com.alvinlkk.chapter04;

import java.util.Objects;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-02-28 18:04
 */
public class IntegerEqTest {

    public static void main(String[] args) {
        Integer a = 500;
        Integer b = 500;
        System.out.println(a == b);  //false
        System.out.println(a == 500);
        System.out.println(Objects.equals(a, b));

        a = 100;
        b = 100;
        System.out.println(a == b);
        System.out.println(Objects.equals(a, b));
    }
}
