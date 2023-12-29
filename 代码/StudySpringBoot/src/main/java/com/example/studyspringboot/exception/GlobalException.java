package com.example.studyspringboot.exception;


import com.example.studyspringboot.commont.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 功能：
 * 作者：熊奎
 * 日期：2023/11/10 10:26
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result serviceException(ServiceException e){
        return Result.error("500",e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result globalException(Exception e) {
        e.printStackTrace();
        return Result.error("500", "系统错误");
    }
}