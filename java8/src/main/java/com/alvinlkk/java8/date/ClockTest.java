package com.alvinlkk.java8.date;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

import org.junit.Test;

/**
 * Clock类提供了访问当前日期和时间的方法，Clock是时区敏感的，
 * 可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-08-30 17:18
 */
public class ClockTest {

    @Test
    public void test1() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        //clock -> instant
        Instant instant = clock.instant();
        // instant -> date
        Date legacyDate = Date.from(instant);
    }

}
