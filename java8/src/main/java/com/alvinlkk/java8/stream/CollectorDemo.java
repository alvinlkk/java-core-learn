package com.alvinlkk.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.alvinlkk.java8.User;

/**
 *
 * Collectors类的使用，包含了几乎每个方法的使用说明和例子
 * Collectors提供针对流归并的各种各样的实现。
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-08-28 14:59
 */
public class CollectorDemo {
    private List<User> users = new ArrayList<>(16);

    @Before
    public void setUp() {
        User user1 = new User("alvin", 19);
        User user2 = new User("kk", 80);
        User user3 = new User("aa", 80);
        User user4 = new User("cc", 33);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    /**
     * 将数据转成Collection
     */
    @Test
    public void toCollectionTest() {
        ArrayList<Integer> list = Stream.of(1, 2, 6, 8).collect(Collectors.toCollection(ArrayList::new));
        HashSet<Integer> set = Stream.of(1, 2, 6, 8).collect(Collectors.toCollection(HashSet::new));
    }

    @Test
    public void toListTest() {
        List<Integer> list = Stream.of(1, 2, 6, 8).collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void toSetTest() {
        Set<Integer> set = Stream.of(1, 2, 6, 8).collect(Collectors.toSet());
        System.out.println(set);
    }

    /**
     * 连接测试
     */
    @Test
    public void joiningTest() {
        String join1 = users.stream().map(User::getUserName).collect(Collectors.joining());
        System.out.println(join1);

        String join2 = users.stream().map(User::getUserName).collect(Collectors.joining(","));
        System.out.println(join2);

        String join3 = users.stream().map(User::getUserName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(join3);
    }

    /**
     * mapping: 映射
     */
    @Test
    public void mappingTest() {
        Map<Integer, List<String>> ageUsersMap = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getUserName, Collectors.toList())));
        System.out.println(ageUsersMap);

        Set<String> userNames = users.stream().collect(Collectors.mapping(User::getUserName, Collectors.toSet()));
        System.out.println(userNames);

    }

    /**
     * collectingAndThen: 将流中的数据通过Collector计算，最终的结果在通过Function再最终处理一下
     */
    @Test
    public void collectingAndThenTest(){
        List<User> list = users.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(list);

        String str = Stream.of("a", "v", "d").collect(Collectors.collectingAndThen(Collectors.joining("$"), x -> x + "ss"));
        System.out.println(str);
    }

    /**
     * 元素数量
     */
    @Test
    public void countingTest() {
        Long count = users.stream().collect(Collectors.counting());
        System.out.println(count);
    }

    /**
     * 最小值
     */
    @Test
    public void minByTest() {
        Optional<Integer> minOp = Stream.of(1, 8, 0, 12).collect(Collectors.minBy(Integer::compareTo));
        System.out.println(minOp.get());
    }

    /**
     * 最大值
     */
    @Test
    public void maxByTest() {
        Optional<Integer> maxOp = Stream.of(1, 8, 0, 12).collect(Collectors.maxBy(Integer::compareTo));
        System.out.println(maxOp.get());
    }

    @Test
    public void summingTest() {
        Integer sumInt = Stream.of(1, 5, 8, 10).collect(Collectors.summingInt(x -> x));
        System.out.println(sumInt);

        //stream中使用方法引用。。。
        Integer sumAge = users.stream().collect(Collectors.summingInt(User::getAge));
        System.out.println(sumAge);

        Double sumDouble = Stream.of(1.1d, 5.2d, 8d, 10d).collect(Collectors.summingDouble(x -> x));
        System.out.println(sumDouble);
    }

    /**
     * 求平均值
     */
    @Test
    public void averagingIntTest() {
        Double avg = users.stream().collect(Collectors.averagingInt(User::getAge));
        System.out.println(avg);
    }

    /**
     * 归并
     */
    @Test
    public void reducingTest() {
        //users.stream().collect(Collectors.reducing(null, (a, b) -> a.));

        Integer sum = Stream.of(1, 5, 8, 12).collect(Collectors.reducing(0, Integer::sum));

        sum = Stream.of(1, 5, 8, 12).collect(Collectors.reducing(Integer::sum)).get();

        String str = Stream.of(1, 5, 8, 12).collect(Collectors.reducing("start", String::valueOf, String::concat));
        System.out.println(str);

    }

    /**
     * 分组
     */
    @Test
    public void groupingByTest() {
        Map<String, List<User>> map1 = users.stream().collect(Collectors.groupingBy(User::getUserName));
        //两个参数，第二个参数是做后续处理
        Map<String, Integer> map2 = users.stream().collect(Collectors.groupingBy(User::getUserName, Collectors.summingInt(User::getAge)));

        TreeMap<String, Integer> map3 = users.stream().collect(Collectors.groupingBy(User::getUserName, TreeMap::new, Collectors.summingInt(User::getAge)));
    }

    /**
     * 根绝boolean, true false进行分组
     */
    @Test
    public void partitioningByTest() {

        Map<Boolean, List<User>> partiMap = users.stream().collect(Collectors.partitioningBy(user -> user.getAge() > 50));
        System.out.println(partiMap);

        Map<Boolean, List<String>> userNamePartsMap = users.stream().collect(Collectors.partitioningBy(user -> user.getAge() > 50, Collectors.mapping(User::getUserName, Collectors.toList())));
        System.out.println(userNamePartsMap);

    }

    /**
     * 元素根据function获取同步的map
     */
    @Test
    public void toMapTest() {
        Map<String, Integer> map1 = users.stream().collect(Collectors.toMap(User::getUserName, User::getAge));

        Map<String, Integer> map2 = users.stream().collect(Collectors.toMap(User::getUserName, User::getAge, Integer::sum));

        Map<String, Integer> map3 = users.stream().collect(Collectors.toMap(User::getUserName, User::getAge, Integer::sum, TreeMap::new));
    }

    /**
     * 获取根据function获取同步的map
     */
    @Test
    public void toConcurrentMapTest() {
        ConcurrentMap<String, Integer> concurrentMap1 = users.stream().collect(Collectors.toConcurrentMap(User::getUserName, User::getAge));

        //如果key相同的时候，调用第三个参数进行处理
        ConcurrentMap<String, Integer> concurrentMap2 = users.stream().collect(Collectors.toConcurrentMap(User::getUserName, User::getAge, Integer::sum));

        ConcurrentHashMap<String, Integer> concurrentMap3 = users.stream().collect(Collectors.toConcurrentMap(User::getUserName, User::getAge, Integer::sum, ConcurrentHashMap::new));
    }

    /**
     * 统计int数据，包括获取最大、平均值、总和等
     */
    @Test
    public void summarizingIntTest() {
        IntSummaryStatistics ageSummary = users.stream().collect(Collectors.summarizingInt(User::getAge));
        System.out.println(ageSummary.getMax());

    }






}
