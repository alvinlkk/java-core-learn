package com.alvinlkk.java8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import org.junit.Test;

/**
 * LocalDate类是Java 8中日期时间功能里表示一个本地日期的类，它的日期是无时区属性的。
 * 可以用来表示生日、节假日期等等。这个类用于表示一个确切的日期，
 * 而不是这个日期所在的时间（如java.util.Date中的2000.01.01表示的实际是这一天的00:00这个瞬间）。
 * <p>
 * LocalDate类位于java.time包下，名叫java.time.LocalDate，创建出来的实例也是不可变对象，
 * 所以涉及它的计算方法将返回一个新的LocalDate。
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-08-30 17:21
 */
public class LocalDateTest {

    @Test
    public void createDateTest() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        localDate = LocalDate.of(2020, 12, 31);
        System.out.println(localDate);

        localDate = LocalDate.of(2020, Month.APRIL, 9);
        System.out.println(localDate);

        localDate = LocalDate.ofYearDay(2020, 200);
        System.out.println(localDate);

        //时间戳
        localDate = LocalDate.ofEpochDay(1000);
        System.out.println(localDate);

        localDate = LocalDate.parse("2011-12-03");
        System.out.println(localDate);

        localDate = LocalDate.parse("2011/12/03", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(localDate);
    }

    @Test
    public void test2() {
        LocalDate localDate = LocalDate.now();

        int year = localDate.getYear();
        System.out.println(year);
        Month month = localDate.getMonth();
        System.out.println(month);
        int monthValue = localDate.getMonthValue();
        System.out.println(monthValue);
        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println(dayOfMonth);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek.getValue());
        int dayOfYear = localDate.getDayOfYear();
        System.out.println(dayOfYear);
    }

    @Test
    public void test3() {
        LocalDate localDate = LocalDate.now();
        //是否是闰年
        boolean leapYear = localDate.isLeapYear();
        System.out.println(leapYear);

        System.out.println(localDate.lengthOfMonth());
        System.out.println(localDate.lengthOfYear());
    }

    @Test
    public void withTest() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate localDate1 = localDate.withYear(2019).withMonth(11).withDayOfMonth(1);
        System.out.println(localDate1);
    }

    @Test
    public void plusMinusTest() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.plusDays(100);
        System.out.println(localDate1);

        LocalDate localDate2 = localDate.minusMonths(1);
        System.out.println(localDate2);

        // 计算两个时间之间的差距
        long until = localDate2.until(localDate1, ChronoUnit.MONTHS);
        System.out.println(until);

        Period period = localDate.until(localDate1);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }


}
