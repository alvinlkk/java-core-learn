package com.alvinlkk.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.alvinlkk.java8.User;

/**
 * stream继承了BaseStream
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-08-25 09:29
 */
public class StreamDemo {

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
     * 创建流
     */
    @Test
    public void createStreamTest() {
        //1. 通过Collection系列集合提供的stream()或者parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2. 通过Arrays中的静态方法stream()获取数组流
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream2 = Arrays.stream(arr);

        //3. 通过Stream类中的静态方法of（）
        Stream<String> stream3 = Stream.of("a", "b", "c");

        //4. 创建无限流
        final Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        //5. 生成流
        Stream<Integer> stream5 = Stream.generate(() -> (int) Math.random());
        stream5.limit(5).forEach(System.out::println);
    }

    /**
     * filter: 筛选出执行结果返回为true的元素
     */
    @Test
    public void filterTest() {
        // 中间操作：不会执行任何操作
        Stream<User> userStream = users.stream().filter(user -> {
            System.out.println("Stream API 的Filter中间操作");
            return user.getAge() > 50;
        });
        // 终止操作：一次性执行全部内容，即：惰性求值
        userStream.forEach(System.out::println);
    }

    /**
     * distinct: 根据hashCode()和equals方法去重
     */
    @Test
    public void distinctTest() {
        // distinct
        users.stream().mapToInt(User::getAge).distinct().forEach(System.out::println);
        Stream.of("aa", "bb", "aa", "cc").distinct().forEach(System.out::println);
    }

    /**
     * 排序
     * sorted(): 自然排序
     * sorted(Comparator<? super T> comparator): 根据传入的比较器进行排序
     */
    @Test
    public void sortedTest() {
        List<String> list = Arrays.asList("ccc", "aaa", "bbb", "ddd", "eee");
        // 自然排序 Comparable
        list.stream().sorted().forEach(System.out::println);

        //自定义排序，根据年龄
        users.stream().sorted((u1, u2) -> {
            if (Objects.equals(u1.getAge(), u2.getAge())) {
                return u1.getUserName().compareTo(u2.getUserName());
            } else {
                return Integer.compare(u1.getAge(), u2.getAge());
            }
        }).forEach(System.out::println);

    }

    /**
     * peek(Consumer<? super T> action): 消费流，主要用于debug操作
     */
    @Test
    public void peekTest() {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .forEach(System.out::println);
    }

    /**
     * limit(long maxSize): 使其元素不超过给定的数量
     */
    @Test
    public void limitTest() {
        users.stream().limit(2).forEach(System.out::println);
    }

    /**
     * skip(long n): 跳过n个元素， 如果n大于流中元素的个数，返回空
     */
    @Test
    public void skipTest() {
        users.stream().skip(1).forEach(System.out::println);
    }


    /**
     * map: 接收lambda表达式， 将元素转换映射为其他的元素
     * mapToInt: 将元素转换为int , 同理mapToLong, mapToDouble
     */
    @Test
    public void mapTest() {
        //map 操作
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        users.stream().map(User::getUserName).forEach(System.out::println);

        // mapToInt
        users.stream().mapToInt(User::getAge).forEach(System.out::println);
    }

    /**
     * flatMap: 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连成一个流.
     * flatMapToInt: 将流转换为IntStream, 同理flatMapToDouble, flatMapToLong
     */
    @Test
    public void flatMapTest() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream().map(StreamDemo::filterCharacter).forEach(stream -> stream.forEach(System.out::println));
        //flatMap的写法
        list.stream().flatMap(StreamDemo::filterCharacter).forEach(System.out::println);

        // flatMap例子
        List<List<User>> usersList = new ArrayList<>();
        usersList.add(users);
        usersList.stream().flatMap(item -> item.stream()).forEach(System.out::println);

        // flatMapToInt例子
        usersList.stream().flatMapToInt(item -> item.stream().mapToInt(User::getAge)).forEach(System.out::println);
    }


    static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();

        for (Character character : str.toCharArray()) {
            list.add(character);
        }

        return list.stream();
    }

    /**
     * forEach 和 forEachOrdered 区别
     */
    @Test
    public void forEachTest() {
        //主要的区别在并行流的处理上
        //输出的顺序不一定（效率更高）
        Stream.of("AAA", "BBB", "CCC").parallel().forEach(s -> System.out.println("Output:" + s));
        //输出的顺序与元素的顺序严格一致
        Stream.of("AAA", "BBB", "CCC").parallel().forEachOrdered(s -> System.out.println("Output:" + s));
    }

    /**
     * toArray(): 转成数组，数组类型为Object
     * toArray(IntFunction<A[]> generator): 转成对应类型的数组
     */
    @Test
    public void toArrayTest() {
        Object[] userObjs = users.stream().toArray();
        System.out.println(Arrays.toString(userObjs));

        User[] userArray = users.stream().toArray(User[]::new);
        System.out.println(Arrays.toString(userArray));
    }

    /**
     * reduce(T identity, BinaryOperator<T> accumulator): 根据identity初始值和accumulator归并
     * reduce(BinaryOperator<T> accumulator): 归并,返回Optional<T>
     * reduce(U identity,
     * BiFunction<U, ? super T, U> accumulator,
     * BinaryOperator<U> combiner）: 第一个参数传递要返回的对象。第二个参数是累加器accumulator，stream中的元素会迭代执行该累加器；第三个元素是组合器combiner，Stream是支持并发操作的，为了避免竞争，对于reduce线程都会有独立的result，combiner的作用在于合并每个线程的result得到最终结果。
     */
    @Test
    public void reduceTest() {
        Integer sumAge = users.stream().map(User::getAge).reduce(0, Integer::sum);
        System.out.println(sumAge);

        Integer maxAge = users.stream().map(User::getAge).reduce(Integer::max).get();
        System.out.println(maxAge);

        /**
         * 第一个参数传递要返回的对象；
         * 第二个参数是累加器accumulator，stream中的元素会迭代执行该累加器；
         * 第三个元素是组合器combiner，Stream是支持并发操作的，为了避免竞争，对于reduce线程都会有独立的result，combiner的作用在于合并每个线程的result得到最终结果。
         */
        Integer sum = Stream.of(1, 5, 3, 2, 23, 2, 2, 3, 5, 1, 1, 3).parallel().reduce(100, Integer::sum, (a, b) -> {
            System.out.println("alvin");
            System.out.println("alvin12");
            return a + b;
        });
        System.out.println(sum);
    }

    /**
     * collect(Supplier<R> supplier,
     *                   BiConsumer<R, ? super T> accumulator,
     *                   BiConsumer<R, R> combiner):一个能创造目标类型实例的方法。accumulator：一个将当元素添加到目标中的方法。combiner：一个将中间状态的多个结果整合到一起的方法（并发的时候会用到）
     */
    @Test
    public void collectTest() {
        /**
         * 一个能创造目标类型实例的方法。
         * accumulator：一个将当元素添加到目标中的方法。
         * combiner：一个将中间状态的多个结果整合到一起的方法（并发的时候会用到)
         * ???
         */
        HashMap<Object, Object> userMap = users.stream().collect(HashMap::new,
                (map, user) -> map.put(user.getUserName(), user), HashMap::putAll );
        System.out.println(userMap);
    }

    /**
     * 取最小值
     */
    @Test
    public void minTest() {
        Integer min = Stream.of(1, 5, 8, 9).min(Integer::compareTo).get();
        System.out.println(min);
    }

    /**
     * 取最大值
     */
    @Test
    public void maxTest() {
        Integer max = Stream.of(1, 5, 8, 5, 9).max(Integer::compareTo).get();
        System.out.println(max);
    }

    /**
     * 返回元素的数量
     */
    @Test
    public void countTest() {
        long count = users.stream().count();
        System.out.println(count);

        long count1 = Stream.of(1, 5, 8, 5, 9).count();
        System.out.println(count1);
    }

    /**
     * 判断是否存在大于某个断言的数据
     */
    @Test
    public void anyMatchTest() {
        boolean flag = Stream.of(1, 5, 8, 5, 9).anyMatch(t -> t > 5);
        System.out.println(flag);
    }

    /**
     * 判断是否所有的元素都满足某个断言
     */
    @Test
    public void allMatchTest() {
        boolean flag = Stream.of(1, 5, 8, 5, 9).allMatch(t -> t > 5);
        System.out.println(flag);
    }

    /**
     * 判断是否没有元素满足某个断言
     */
    @Test
    public void noneMatchTest() {
        boolean flag = Stream.of(1, 5, 8, 5, 9).noneMatch(t -> t > 5);
        System.out.println(flag);

        flag = Stream.of(1, 5, 8, 5, 9).noneMatch(t -> t > 15);
        System.out.println(flag);
    }

    /**
     * 查找第一个元素
     */
    @Test
    public void findFirstTest() {
        Optional<Integer> first = Stream.of(1, 5, 8, 5, 9).findFirst();
        System.out.println(first.get());
    }


    /**
     * 查找任意一个元素, 串行下一般返回第一个，并行下就不一定了
     */
    @Test
    public void findAnyTest() {
        Optional<Integer> ele = Stream.of(1, 5, 8, 5, 9).findAny();
        System.out.println(ele.get());
    }

    /**
     * 通过builder建造流
     */
    @Test
    public void builderTest() {
        Stream.Builder<Object> builder = Stream.builder();
        builder.accept(66);
        builder.add(10).add(20);
        builder.accept(80);
        builder.build().forEach(System.out::println);
    }

    /**
     * 通过iterate建造流
     */
    @Test
    public void iterateTest() {
        Stream<Integer> iterateStream = Stream.iterate(5, t -> t + 4);
        iterateStream.limit(4).forEach(System.out::println);
    }

    /**
     * 通过generate 创建流
     */
    @Test
    public void genrateTest() {
        Stream.generate(Math::random).limit(1).forEach(System.out::println);
    }

    /**
     * 连接流
     */
    @Test
    public void concatTest() {
        Stream<Integer> stream1 = Stream.of(1, 5, 9);
        Stream<Integer> stream2 = Stream.of(7, 6, 1);
        Stream<Integer> concatStream = Stream.concat(stream1, stream2);
        concatStream.forEach(System.out::println);
    }

}
