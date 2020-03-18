package com.alvinlkk.interfaces;

/**
 *
 * 默认方法冲突：
 * 1. 超类优先
 * 2. 接口冲突
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2019-09-03 23:34
 */
public class DefaultImplTest {

}

class Student implements Person,Named {

    @Override
    public String getName() {
        return Person.super.getName();
    }
}


interface Named {
     String getName();
}

interface Person {
    default String getName() { return getClass().getName() + "_" + hashCode(); }
}