package com.lee7s.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author somg
 * @date 2023/8/11 12:40
 * @do 流的终止操作
 */
public class OperationTest02 {

    /**
     * 非短路操作
     *      每一个元素都要用到才会终止操作 count min max reduce toArray collect forEachOrdered forEach
     * 短路操作
     *      并不是每一个元素都会用到就终止操作 allMatch anyMatch noneMatch findFirst findAny
     */

    @Test
    public void test01(){
        String words = "Beijing welcome you I love China";
        Stream.of(words.split(" "))
                .parallel()
                .forEach(System.out::println); // 如果式串行那么forEach有序 如果是并行forEach无序
    }

    @Test
    public void test02(){
        String words = "Beijing welcome you I love China";
        Stream.of(words.split(" "))
                .parallel()
                .forEachOrdered(System.out::println); // 如果式串行那么forEachOrdered有序(和forEach一样) 如果是并行forEachOrdered也有序
    }

    @Test
    public void test03(){
        String words = "Beijing welcome you I love China";
        List<String> collect = Stream.of(words.split(" "))
                .collect(Collectors.toList()); // 将流中的元素收集到一个集合
        System.out.println(collect);
    }

    @Test
    public void test04(){
        String words = "Beijing welcome you I love China";
        Object[] strings = Stream.of(words.split(" "))
                .toArray();// 将流中的元素收集到一个数组
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    @Test
    public void test05(){
        String words = "Beijing welcome you I love China";
        Integer integer = Stream.of(words.split(" "))
                .map(String::length)
                .filter(len -> len > 200)
                .reduce((i, j) -> i + j).orElse(-1);// 做计算 但是注意如果被上面的操作将流中的元素过滤为空 那么报错 加上orElse就不会 如果为空就返回-1
        System.out.println(integer);

    }

    @Test
    public void test06(){
        String words = "Beijing welcome you I love China";
        long count = Stream.of(words.split(" "))
                .count();// 求和操作
        System.out.println(count);
    }

    @Test
    public void test07(){
        String words = "Beijing welcome you I love China";
        String max = Stream.of(words.split(" "))
                .max((i, j) -> j.length() - i.length()).orElse("no"); // max函数可以根据规则找到最大值 默认规则式 第一个元素减去第二个元素(找最大) 反过来的话就可以用max求最小
        System.out.println(max);
    }

    @Test
    public void test08(){
        String words = "Beijing welcome you I love China";
        String min = Stream.of(words.split(" "))
                .min((i, j) -> j.length() - i.length()).orElse("no"); // min函数可以根据规则找到最小值 默认规则式 第一个元素减去第二个元素(找最小) 反过来的话就可以用min求最大
        System.out.println(min);
    }


    @Test
    public void test09(){
        String words = "Beijing welcome you I love China";
        boolean b = Stream.of(words.split(" "))
                .allMatch(word -> word.length() > 3);// 全部都大于三就是true 否则false
        System.out.println(b);
    }

    @Test
    public void test10(){
        String words = "Beijing welcome you I love China";
        boolean b = Stream.of(words.split(" "))
                .anyMatch(word -> word.length() > 3);// 只要有长度大于三的就是true 否则false
        System.out.println(b);
    }

    @Test
    public void test11(){
        String words = "Beijing welcome you I love China";
        boolean b = Stream.of(words.split(" "))
                .noneMatch(word -> word.length() > 3);// 全部都不大于三就是true 否则false
        System.out.println(b);
    }

    @Test
    public void test12(){
        String words = "Beijing welcome you I love China";
        String s = Stream.of(words.split(" "))
                .findFirst().orElse("no"); // 获取流中的第一个元素 如果没有元素返回no 执照第一个
        System.out.println(s);
    }

    @Test
    public void test13(){
        String words = "Beijing welcome you I love China";
        String s = Stream.of(words.split(" "))
                .findAny().orElse("no"); // 和findFirst差不多
        System.out.println(s);
    }




}
