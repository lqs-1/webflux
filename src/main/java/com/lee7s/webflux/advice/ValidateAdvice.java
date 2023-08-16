package com.lee7s.webflux.advice;

import com.lee7s.webflux.exception.ValidateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

/**
 * @author somg
 * @date 2023/8/16 16:40
 * @do 统一异常处理类
 */
@RestControllerAdvice
public class ValidateAdvice {

    // 统一的全部异常处理
//    @ExceptionHandler
//    public ResponseEntity<String> ValidateExceptionHandler(WebExchangeBindException exception){
//        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
//    }


    // 单独异常处理
    @ExceptionHandler
    public ResponseEntity<String> ValidateExceptionHandler(ValidateException exception){
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }





}
