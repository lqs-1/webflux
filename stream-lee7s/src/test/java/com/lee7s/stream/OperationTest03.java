package com.lee7s.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author somg
 * @date 2023/8/11 13:31
 * @do 收集操作
 */
public class OperationTest03 {

    @Test
    public void test01() {
        Student s1 = new Student("lee7s", 21);
        Student s2 = new Student("lee47s", 21);
        Student s3 = new Student("22", 21);
        Student s4 = new Student("23", 213);
        Student s5 = new Student("24", 216);
        Student s6 = new Student("25", 217);
        Student s7 = new Student("26", 210);
        Student s8 = new Student("27", 2132);

        // 普通集合的收集
        Set<Integer> list1 = Stream.of(s1, s2, s3, s4, s5, s6, s7, s8)
                .map(s -> s.getAge())
                // .collect(Collectors.toList());
                // .collect(Collectors.toSet());
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(list1);


        // map集合的收集 分组 按照名字分组
        Map<String, List<Student>> map1 = Stream.of(s1, s2, s3, s4, s5, s6, s7, s8)
                .collect(Collectors.groupingBy(Student::getName));
        System.out.println(map1);

        // map集合的收集 分组 按照名字分组 在统计
        Map<String, Double> map2 = Stream.of(s1, s2, s3, s4, s5, s6, s7, s8)
                .collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getAge)));
        System.out.println(map2);

        // map集合的收集 分组 按照名字分组 只能分两块 男女 大小 多少 key是Boolean类型
        Map<Boolean, List<Student>> lee7s1 = Stream.of(s1, s2, s3, s4, s5, s6, s7, s8)
                .collect(Collectors.partitioningBy(s -> s.getName().equals("lee7s")));
        System.out.println(lee7s1);

        // map集合的收集 统计 分组 按照名字分组 只能分两块 男女 大小 多少 key是Boolean类型 value可以是计算出来的值 统计
        Map<Boolean, Double> lee7s2 = Stream.of(s1, s2, s3, s4, s5, s6, s7, s8)
                .collect(Collectors.partitioningBy(s -> s.getName().equals("lee7s"), Collectors.averagingDouble(Student::getAge)));
        System.out.println(lee7s2);

        // map集合的收集
        Map<String, Integer> collect = Stream.of(s1, s2, s3, s4, s5, s6, s7, s8)
                .collect(Collectors.toMap(Student::getName, Student::getAge));

        System.out.println(collect);
    }


}
