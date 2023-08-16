package com.lee7s.webflux.exception;

import lombok.Data;

/**
 * @author somg
 * @date 2023/8/16 15:36
 * @do 参数校验异常类
 */
@Data
public class ValidateException extends RuntimeException {

    private String errorField;

    private Object errorValue;

    public ValidateException(){
        super();
    }

    public ValidateException(String message, String errorField, Object errorValue){
        super(message);
        this.errorField = errorField;
        this.errorValue = errorValue;
    }




}
