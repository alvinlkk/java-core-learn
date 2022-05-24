package com.alvinlkk.java8.optional;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.alvinlkk.java8.User;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-08-23 18:14
 */
public class OptionalTest {

    /**
     * 测试empty方法
     */
    @Test
    public void testEmpty() {
        Optional<User> userOptional = Optional.empty();
        //调用get会抛出NoSuchElementException
        //User user = userOptional.get();
        //System.out.println(user);
    }


    /**
     * 测试of 方法, of方法中传入null,会报空指针
     */
    @Test
    public void testOf() {
        Optional<User> optional = Optional.of(new User());
        User user = optional.get();
        System.out.println(user);
        //会报空指针
//        Optional<User> optional2 = Optional.of(null);
    }

    /**
     * 测试ofNullable方法，ofNullable可以传入null，返回空实例, of传入null，报空指针
     */
    @Test
    public void testOfNullable() {
        Optional<User> optional = Optional.ofNullable(new User());
        User user = optional.get();
        System.out.println(user);

        Optional<User> optional2 = Optional.ofNullable(null);
    }

    /**
     * get(): 获取值，如果为空，抛出NoSuchElementException异常
     */
    @Test
    public void testGet() {
        Optional<User> optional = Optional.ofNullable(new User());
        User user = optional.get();
        System.out.println(user);
    }

    /**
     * orElse(T other): 如果值存在，返回值，若值为null, 则返回other
     */
    @Test
    public void testOrElse() {
        Optional<User> optional = Optional.ofNullable(new User("alvin", 18));
        User user = optional.orElse(new User("kk", 19));
        Assert.assertEquals("alvin", user.getUserName());

        optional = Optional.ofNullable(null);
        user = optional.orElse(new User("kk", 19));
        Assert.assertEquals("kk", user.getUserName());
    }

    /**
     * orElseGet(Supplier<? extends T> other): 如果值存在，直接返回， 如果值为null, 调用Supplier生成
     */
    public void testOrElseGet() {
        Optional<User> optional = Optional.ofNullable(new User("alvin", 18));
        User user = optional.orElseGet(() -> new User("kk", 19));
        Assert.assertEquals("alvin", user.getUserName());

        optional = Optional.ofNullable(null);
        user = optional.orElseGet(() -> new User("kk", 19));
        Assert.assertEquals("kk", user.getUserName());
    }

    /**
     * orElseThrow(Supplier<? extends X> exceptionSupplier)：如果值存在，直接返回， 如果值为null, 调用Supplier生成异常，抛出异常
     */
    @Test
    public void testOrElseThrow() {
        Optional<User> optional = Optional.ofNullable(new User("alvin", 18));
        User user = optional.orElseThrow(() -> new RuntimeException("出错"));
        Assert.assertEquals("alvin", user.getUserName());

        optional = Optional.ofNullable(null);
        user = optional.orElseThrow(() -> new RuntimeException("出错"));
    }

    /**
     * 测试isPresent，返回是值是否存在
     */
    @Test
    public void testIsPresent() {
        Optional<User> optional = Optional.ofNullable(new User());
        boolean present = optional.isPresent();
        Assert.assertTrue(present);

        Optional<User> optional2 = Optional.ofNullable(null);
        boolean present1 = optional2.isPresent();
        Assert.assertFalse(present1);
    }

    /**
     * ifPresent(Consumer<? super T> consumer): 如果存在值，则执行consume
     */
    @Test
    public void testIfPresent() {
        Optional<User> optional = Optional.ofNullable(new User("alvin", 18));
        optional.ifPresent(user -> System.out.println(user.getUserName()));
    }

    /**
     * filter(Predicate<? super T> predicate): 根据传入的断言来判断是否返回原值，还是空值
     */
    @Test
    public void testFilter() {
        /*Optional<User> optional = Optional.ofNullable(new User("alvin", 18));
        Optional<User> userOptional = optional.filter(user -> StrUtil.equals("alvin", user.getUserName()));
        Assert.assertTrue(userOptional.isPresent());

        userOptional = optional.filter(user -> StrUtil.equals("kk", user.getUserName()));
        Assert.assertFalse(userOptional.isPresent());*/
    }

    /**
     * map(Function<? super T, ? extends U> mapper): 如果有值对其处理，并返回处理后的 Optional，否则返回 Optional.empty()。
     */
    @Test
    public void testMap() {
        Optional<User> optional = Optional.ofNullable(new User("alvin", 18));
        Optional<String> userOptional = optional.map(user -> user.getUserName());
        Assert.assertEquals("alvin", userOptional.get());
    }

    /**
     * flatMap(Function<? super T, Optional<U>> mapper)
     * 功能和map类似，但是flatMap返回的结果Optional是由我们的代码封装的。
     */
    @Test
    public void testFlatMap() {
        Optional<User> optional = Optional.ofNullable(new User("alvin", 18));
        Optional<String> userOptional = optional.flatMap(user -> Optional.of(user.getUserName()));
        Assert.assertEquals("alvin", userOptional.get());
    }

}
