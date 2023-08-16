package com.lee7s.webflux.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

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
    // @NotNull(message = "id不能为空")
    private String id;


    // @NotNull(message = "名字不能为空")
    private String name;

    // @Range(min = 10, max = 90, message = "年龄不在范围内")
    private Integer age;

}
