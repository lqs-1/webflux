package com.lee7s.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author somg
 * @date 2023/8/11 12:10
 * @do 流的中间操作
 */
public class OperationTest01 {


    /**
     * 有状态操作
     *      当前元素和其他元素有关系 sorted distinct skip等
     * 无状态操作
     *      当前元素和之前元素没有关系 map forEach(终止操作) mapToxxx flatMap peek filter
     */

    @Test
    public void test01(){
        String words = "Beijing welcome you I love China";
        Stream.of(words.split(" "))
                .peek(System.out::print) // 中间操作
                .map(String::length) // 中间操作 映射
                .forEach(System.out::println); // 终止操作
    }

    @Test
    public void test02(){
        IntStream.range(1, 10)
                .mapToObj(i -> "No " + i) // 映射成一个对象
                .forEach(System.out::println);
    }

    @Test
    public void test03(){
        String[] nums = {"111", "222", "333"};
        Arrays.stream(nums)
                .mapToInt(Integer::valueOf) // 映射成整形
                .forEach(System.out::println);
    }

    @Test
    public void test04(){
        String words = "Beijing welcome you I love China";
        Stream.of(words.split(" "))
                .flatMap(word -> Stream.of(word.split(""))) // 中间操作 返回值式一个流 将数据映射成新的流在放入当前流中
                .forEach(System.out::println); // 终止操作
    }

    @Test
    public void test05(){
        String words = "Beijing welcome you I love China";
        Stream.of(words.split(" "))
                .flatMap(word -> Stream.of(word.split(""))) // 中间操作 返回值式一个流 将数据映射成新的流在放入当前流中
                .filter(ch -> ch != ("a")) // 将满足条件的筛选出来
                .sorted(Comparator.reverseOrder()) // 将stream中的数据拍戏 可以无参数 加上 Comparator.reverseOrder() 就是反转
                .distinct() // 去除重复
                .skip(2) // 忽略前两个
                .forEach(System.out::println); // 终止操作
    }

    /**
     * 有状态和无状态一起使用的时候 以有状态为分水岭 将有状态之前的操作执行完了 在执行后面
     */
    @Test
    public void test06(){
        IntStream.range(1, 9)
                .peek(System.out::print)
                .sorted()
                .forEach(System.err::print);
    }






}
