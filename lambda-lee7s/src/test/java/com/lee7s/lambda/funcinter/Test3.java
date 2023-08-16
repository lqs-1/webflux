package com.lee7s.lambda.funcinter;

import org.junit.jupiter.api.Test;

/**
 * @author somg
 * @date 2023/8/10 19:15
 * @do 有参有返回值的函数式接口
 */

@FunctionalInterface
interface Some3{
    String  doSome(String a, int b);
}
public class Test3 {

    @Test
    public void test01(){
        Some3 some = new Some3() {
            @Override
            public String doSome(String a, int b) {
                return a + b;
            }
        };
        System.out.println(some.doSome("匿名内部类实现", 3));
    }

    @Test
    public void test02(){
        Some3 some = (arg1, arg2) -> arg1 + arg2;
        System.out.println(some.doSome("lambda表达式实现", 3));
    }


}
