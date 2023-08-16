package com.lee7s.lambda.sysfunciter;

import org.junit.jupiter.api.Test;

import java.util.function.*;

/**
 * @author somg
 * @date 2023/8/10 20:02
 * @do 内置函数式接口
 */
public class FunctionTest {


    /**
     * Predicate 断言 判断 返回为 Boolean 一个参数
     * 有 与或非操作
     */
    @Test
    void test01() {
        Predicate<Integer> predicateOne = (i) -> i > 8;
        System.out.println(predicateOne.test(2));
        System.out.println(predicateOne.test(9));

        Predicate<Integer> predicateTwo = x -> x > 4;
        Predicate<Integer> predicateThree = y -> y < 60;
        System.out.println(predicateTwo.and(predicateThree).test(9));
        System.out.println(predicateTwo.or(predicateThree).test(10));
        System.out.println(predicateTwo.negate().test(10));

        System.out.println(Predicate.isEqual("Lee7s").test("lee7s"));

        DoublePredicate doublePredicate = j -> j < 3;
        System.out.println(doublePredicate.test(2));
    }


    /**
     * Consumer 消费 一个入参 没有返回值
     */
    @Test
    void test02() {
        Consumer<String> con01 = System.out::println;
        con01.accept("lee7s");

        Consumer<Integer> con02 = n -> System.out.println(n + 3);
        Consumer<Integer> con03 = n -> System.out.println(n * 3);
        con02.andThen(con03).accept(4);
    }


    /**
     * Supplier 没有入参 有一个返回值
     */
    @Test
    void test03() {
        Supplier<String> supp01 = () -> "lee7s";
        System.out.println(supp01.get());
    }


    /**
     * Function 一个参数 一个返回值
     */
    @Test
    void test04() {
        Function<Integer, String> function01 = i -> "lee7s" + i;
        System.out.println(function01.apply(2002));

        Function<Integer, Integer> function02 = i -> i * 2;
        Function<Integer, Integer> function03 = i -> i * i;
        System.out.println(function02.andThen(function03).apply(3)); // 先将3作为function02的参数算出6，再将6作为function03的参数算出36
        System.out.println(function02.compose(function03).apply(3)); // 先将3作为function03的参数算出9，再将6作为function02的参数算出18

        System.out.println(Function.identity().apply("lee7s")); // 放什么就是什么
    }


    /**
     * UnaryOperator 一个参数 一个返回值 两者类型相同 和Function差不多
     */
    @Test
    void test05() {
        UnaryOperator<Integer> unaryOperator01 = i -> i;
        System.out.println(unaryOperator01.apply(4));

        UnaryOperator<Integer> unaryOperator02 = i -> i * 2;
        UnaryOperator<Integer> unaryOperator03 = i -> i * i;
        System.out.println(unaryOperator02.andThen(unaryOperator03).apply(3)); // 先将3作为unaryOperator02的参数算出6，再将6作为unaryOperator03的参数算出36
        System.out.println(unaryOperator02.compose(unaryOperator03).apply(3)); // 先将3作为unaryOperator03的参数算出9，再将6作为unaryOperator02的参数算出18

        System.out.println(UnaryOperator.identity().apply("lee7s"));
    }

    /**
     * BiFunction 两个参数 一个返回值
     */
    @Test
    void test06(){
        BiFunction<Integer, Integer, String> biFunction01 = (x, y) -> "" + x + y;
        System.out.println(biFunction01.apply(2, 3));

        BiFunction<Integer, Integer, Integer> biFunction02 = (x, y) -> x + y;
        Function<Integer, String > function01 = i -> "lee7s" + i;
        System.out.println(biFunction02.andThen(function01).apply(2, 9)); // 先将2，9算出biFunction02为11，在将11作为function01的参数 得到lee7s11

    }

    /**
     * BinaryOperator 两个参数 一个返回值 三个类型都一样
     */
    @Test
    void test07(){
        BinaryOperator<Integer> binaryOperator01 = (x, y) -> x * y;
        System.out.println(binaryOperator01.apply(1, 6));

        BinaryOperator<Integer> binaryOperator02 = (x, y) -> x + y;
        Function<Integer, String > function01 = i -> "lee7s" + i;
        System.out.println(binaryOperator02.andThen(function01).apply(2, 9)); // 先将2，9算出binaryOperator02为11，在将11作为function01的参数 得到lee7s11

        Student s1 = new Student("张三", 12);
        Student s2 = new Student("李四", 19);
        StudentComparator studentComparator = new StudentComparator();
        System.out.println(BinaryOperator.minBy(studentComparator).apply(s1, s2).getName()); // 两个中获取比较小的
        System.out.println(BinaryOperator.maxBy(studentComparator).apply(s1, s2).getName()); // 两个中获取比较小的

    }


}
