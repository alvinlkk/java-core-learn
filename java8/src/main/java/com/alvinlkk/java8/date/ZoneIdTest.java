package com.alvinlkk.java8.date;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TimeZone;

import org.junit.Test;

/**
 *
 * JDK8中新加的时区类
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-08-30 16:43
 */
public class ZoneIdTest {

    @Test
    public void test1() {
        //创建时区
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        System.out.println(shanghaiZoneId);

        //获取默认的时区
        ZoneId sysemZoneId = ZoneId.systemDefault();
        System.out.println(sysemZoneId);

        // 获取所有合格的"区域/城市"字符串
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
        
        // 老的时区类转换为新的
        ZoneId oldToNewZoneId = TimeZone.getDefault().toZoneId();
        System.out.println(oldToNewZoneId);
    }

    @Test
    public void useTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        //ZonedDateTime 对象由两部分构成，LocalDateTime 和 ZoneId，其中 2018-03-03T15:26:56.147 部分为 LocalDateTime，+08:00[Asia/Shanghai] 部分为ZoneId。
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, shanghaiZoneId);
        System.out.println(zonedDateTime);
    }

    @Test
    public void test3() {
        ZoneOffset zoneOffset = ZoneOffset.of("+09:00");
        LocalDateTime localDateTime = LocalDateTime.now();
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
        System.out.println(offsetDateTime);
    }
}
