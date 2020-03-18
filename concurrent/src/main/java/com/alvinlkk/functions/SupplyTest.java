package com.alvinlkk.functions;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * 函数式编程 - supply
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-09-04 09:56
 */
public class SupplyTest {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "hello";
        System.out.println(supplier.get());

        IntSupplier intSupplier = () -> 1;
        System.out.println(intSupplier.getAsInt());
    }

}
