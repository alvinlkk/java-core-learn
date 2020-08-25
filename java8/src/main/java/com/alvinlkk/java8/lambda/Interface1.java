package com.alvinlkk.java8.lambda;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-08-23 17:29
 */
public class Interface1 {

    @FunctionalInterface
    interface Formula {

        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(positive(a));
        }

        static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {

        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        Formula.positive(10);

        // ???
//        Formula formula2 = (x) -> sqrt(x);
    }
}
