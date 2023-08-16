package com.lee7s.routerfunction.utils;

import com.lee7s.routerfunction.entity.Student;
import com.lee7s.routerfunction.exception.ValidateException;
import org.springframework.util.StringUtils;

import java.util.stream.Stream;

/**
 * @author somg
 * @date 2023/8/16 15:40
 * @do 参数校验工具类 自定义异常处理 参数校验
 */

public class ValidateUtils {

    private static final String[] IGNORE_NAMES = {"admin", "super", "lqss"}; // 非法名字
    private static final Integer[] AGE_LIMIT = {1, 90}; // 年龄范围







    public static void validateName(String name){
        if (name.isEmpty()){
            throw new ValidateException("名字不能为空", "name", "");
        }
        Stream.of(IGNORE_NAMES).filter(ignoreName -> ignoreName.equalsIgnoreCase(name)).findAny().ifPresent(ignoreName -> {
            throw new ValidateException("名字非法", "name", ignoreName);
        });
    }

    public static void validateId(String id){
        if (id.isEmpty()){
            throw new ValidateException("id不能为空", "id", "");
        }
    }

    public static void validateAge(Integer age){
        if (age == null){
            throw new ValidateException("年龄不能为空", "age", "");
        } else if (age < AGE_LIMIT[0] || age > AGE_LIMIT[1]) {
            throw new ValidateException("年龄不在范围内","age", age);
        }
    }


}
