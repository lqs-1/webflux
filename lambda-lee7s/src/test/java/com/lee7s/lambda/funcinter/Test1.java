package com.lee7s.lambda.funcinter;

import org.junit.jupiter.api.Test;

/**
 * @author somg
 * @date 2023/8/10 19:15
 * @do 无参无返回值的函数式接口
 */

@FunctionalInterface
interface Some{
    void doSome();
}


public class Test1 {

    @Test
    public void test01(){
        Some some = new Some() {
            @Override
            public void doSome() {
                System.out.println("匿名内部类实现");
            }
        };
        some.doSome();
    }

    @Test
    public void test02(){
        Some some = () -> {
            System.out.println("使用lambda表达式实现");
        };
        some.doSome();
    }


}
