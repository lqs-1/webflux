package com.lee7s.lambda.method;

import lombok.Data;

/**
 * @author somg
 * @date 2023/8/10 21:07
 * @do Person实体 实例方法第一个参数之前有一个隐藏参数this
 */
public class Person {

    private String name;

    private Integer age;

    public Person(){}

    public Person(String name){
        this.name = name;
    }

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    // 静态方法
    public static void sleeping(int hours){
        System.out.println("休息了 " + hours + " 小时");
    }

    // 实例方法
    public String play(int minutes){
        return this.name + " 已经完了 " + minutes + " 分钟了";
    }

    // 实例方法
    public void study(String course){
        System.out.println(this.name + " 正在学习 " + course);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
