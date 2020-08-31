package com.alvinlkk.java8.methodReference;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.alvinlkk.java8.User;

/**
 * 方法引用，相当于lambda表达式的一种更加简洁的方式
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-08-23 17:42
 */
public class MethodReferenceDemo {

    /**
     * 静态方法引用 类::方法
     */
    @Test
    public void testStaticMethodRef() {
        Function<String, Integer> function1 = x -> Integer.valueOf(x);
        System.out.println(function1.apply("12"));

        //上面的lambda表达式可以用下面的静态方法引用
        Function<String, Integer> function2 = Integer::valueOf;
        System.out.println(function2.apply("12"));
    }

    /**
     * 类名::实例方法名，若Lambda表达式的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，就可以使用这种方法
     */
    @Test
    public void testClassMethdoRef() {
        //类名::实例方法名，若Lambda表达式的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，就可以使用这种方法
        BinaryOperator<String> op = String::concat;
        System.out.println(op.apply("a", "b"));
    }

    /**
     * 实例方法引用 实例::方法
     */
    @Test
    public void testObjMethodRef() {
        Consumer<String> consumer1 = x -> System.out.println(x);
        consumer1.accept("alvin");

        //上面的lambda表达式可以用实例方法引用来处理
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("alvin");

        User user = new User("alvin", 18);
        Supplier<String> userSupply = user::getUserName;
        System.out.println(userSupply.get());
    }

    /**
     * 构造函数方法引用 类::new
     */
    @Test
    public void constructMethodRef() {
        //构造器引用，构造器的参数列表需要和接口的参数保持一致
        BiFunction<String, Integer, User> biFunction = User::new;
        User alvinUser = biFunction.apply("alvin", 18);
        System.out.println(alvinUser.getUserName());
    }

    /**
     * 数组引用
     */
    @Test
    public void arrayRefTest() {
        Function<Integer, String[]> function1 = x -> new String[x];
        String[] strings1 = function1.apply(10);
        System.out.println(strings1.length);

        Function<Integer, String[]> function2 = String[]::new;
        String[] strings2 = function2.apply(10);
        System.out.println(strings1.length);
    }



}
