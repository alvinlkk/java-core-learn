package com.alvinlkk.java8.date;

import java.time.LocalTime;

import org.junit.Test;

/**
 * LocalTime类是Java 8中日期时间功能里表示一整天中某个时间点的类，它的时间是无时区属性的（早上10点等等）。
 * 比如你需要描述学校几点开学，这个时间不涉及在什么城市，这个描述是对任何国家城市都适用的，此时使用无时区的LocalTime就足够了。
 * LocalTime类的对象也是不可变的，所以计算方法会返回一个新的LocalTime实例。
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-08-31 19:34
 */
public class LocalTimeTest {

    @Test
    public void createTest() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime localTime1 = LocalTime.of(21, 30);
        System.out.println(localTime1);

        LocalTime localTime2 = LocalTime.of(21, 30, 59, 11001);
        System.out.println(localTime2);
    }
}
