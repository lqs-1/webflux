package com.lee7s.lambda.funcinter;

import org.junit.jupiter.api.Test;

/**
 * @author somg
 * @date 2023/8/10 19:15
 * @do 无参有返回值的函数式接口
 */

@FunctionalInterface
interface Some2{
    String  doSome();
}
public class Test2 {

    @Test
    public void test01(){
        Some2 some = new Some2() {
            @Override
            public String doSome() {
                return "匿名内部类";
            }
        };
        System.out.println(some.doSome());
    }

    @Test
    public void test02(){
        Some2 some = () -> "使用lambda表达式实现";
        System.out.println(some.doSome());
    }

}
