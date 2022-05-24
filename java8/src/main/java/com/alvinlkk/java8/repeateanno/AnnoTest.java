package com.alvinlkk.java8.repeateanno;

import java.lang.annotation.Repeatable;

import org.junit.Test;

/**
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-09-01 09:35
 */
public class AnnoTest {

    @Test
    public void test() {
        Hint hint = Person1.class.getAnnotation(Hint.class);
        System.out.println(hint);

        Hints hints1 = Person1.class.getAnnotation(Hints.class);
        System.out.println(hints1);

        Hint[] hints2 = Person2.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);
    }
}

@interface Hints {
    Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint {
    String value();
}

@Hints({@Hint("hint1"), @Hint("hint2")})
class Person1 {
}

@Hint("hint1")
@Hint("hint2")
class Person2 {
}