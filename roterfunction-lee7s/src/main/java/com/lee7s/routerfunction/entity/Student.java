package com.lee7s.routerfunction.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author somg
 * @date 2023/8/11 18:13
 * @do 学生实体
 */
@Data
@Document("t_student")
public class Student {

    // mongodb的id为字符串
    @Id
    private String id;

    private String name;

    private Integer age;

}
