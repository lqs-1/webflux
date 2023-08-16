package com.lee7s.lambda.method;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author somg
 * @date 2023/8/10 21:13
 * @do 方法测试
 */
public class MethodTest {

    @Test
    public void test01() {
        // 实例方法 一般使用
        Person lee7s = new Person("lee7s");


        // 静态方法 类名::方法名 只有一个输入 没有返回值 符合Consumer 根据情况选择
        Consumer<Integer> consumer = Person::sleeping;
        consumer.accept(8); // Person.sleeping(8);


        // 实力方法 实例名::方法名 根据情况选择 这种方法和下面的方法差不多 这里没有使用隐藏的this当前对象 注意区分
        Function<Integer, String> function = lee7s::play;
        System.out.println(function.apply(3)); // System.out.println(lee7s.play(3));

        Consumer<String> consumer02 = lee7s::study;
        consumer02.accept("webflux"); // lee7s.study("webflux");

        Supplier<String> stringSupplier = lee7s::toString;
        System.out.println(stringSupplier.get()); // System.out.println(lee7s.toString());

        // 特殊情况 因为实力方法默认有一个this参数 this表示当前队形 这个时候 需要 类名::实例方法 因为当前对象已经有了lee7s 所有根据情况选择
        BiFunction<Person, Integer, String> biFunction = Person::play;
        System.out.println(biFunction.apply(lee7s, 3)); // System.out.println(lee7s.play(3));


        // 构造方法 类名::new
        // 无参 没有输入 一个输出(当前对象)
        Supplier<Person> supplier01 = Person::new; // Person supplier01 = new Person();
        System.out.println(supplier01.get());
        // 有参 仅有一个参数 一个输出(当前对象)
        Function<String, Person> function1 = Person::new;
        System.out.println(function1.apply("leeeee")); // Person function1 = new Person("leeee");

        // 有参 仅有两个参数 一个输出(当前对象)
        BiFunction<String, Integer, Person> biFunction1 = Person::new;
        System.out.println(biFunction1.apply("string", 2)); // Person biFunction1 = new Person("string", 2);
    }


}
