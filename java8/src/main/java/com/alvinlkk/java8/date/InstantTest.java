package com.alvinlkk.java8.date;

import java.time.Clock;
import java.time.Instant;

import org.junit.Test;

/**
 * Instant类在Java日期与时间功能中，表示了时间线上一个确切的点
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-08-30 16:57
 */
public class InstantTest {

    @Test
    public void createInstantDemo() {
        Instant now = Instant.now();
        System.out.println(now);

        Instant instant1 = Instant.now(Clock.systemUTC());
        System.out.println(instant1);

        Instant instant2 = Instant.ofEpochSecond(3);
        System.out.println(instant2);

        Instant instant3 = Instant.ofEpochSecond(3, 1);
        System.out.println(instant3);

        Instant instant4 = Instant.ofEpochMilli(3);
        System.out.println(instant4);

        Instant instant5 = Instant.parse("2007-12-03T10:15:30.00Z");
        System.out.println(instant5);

    }

    @Test
    public void getTest() {
        Instant now = Instant.now();
        //距离初始时间的秒钟数
        System.out.println(now.getEpochSecond());
        //在当前一秒内的第几纳秒
        System.out.println(now.getNano());
    }

    /**
     * 计算
     */
    @Test
    public void opTest() {
        Instant instant = Instant.now();
        Instant instant1 = instant.minusMillis(1000);
        System.out.println(instant1);
        instant1.plusSeconds(50);
        System.out.println(instant1);
        System.out.println(instant1.toEpochMilli());

    }
}
