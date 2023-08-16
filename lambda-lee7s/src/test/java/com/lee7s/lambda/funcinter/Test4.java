package com.lee7s.lambda.funcinter;

import org.junit.jupiter.api.Test;

/**
 * @author somg
 * @date 2023/8/10 19:15
 * @do 有默认方法的函数式接口 默认方法和继承的Object的方法可以共存，但抽象方法只有一个
 */

@FunctionalInterface
interface Some4{

    String  doSome(String a, int b);


    default void doOther(){
        System.out.println("默认方法");
    }

    boolean equals(Object obj);

}


public class Test4 {

    @Test
    public void test01(){
        Some4 some = new Some4() {
            @Override
            public String doSome(String a, int b) {
                return a + b;
            }
        };
        System.out.println(some.doSome("匿名内部类实现", 4));
    }

    @Test
    public void test02(){
        Some4 some = (arg1, arg2) -> arg1 + arg2;
        System.out.println(some.doSome("lambda表达式实现", 4));
    }

}
