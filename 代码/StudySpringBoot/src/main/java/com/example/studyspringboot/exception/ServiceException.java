package com.example.studyspringboot.exception;

/**
 * 功能：
 * 作者：熊奎
 * 日期：2023/11/10 10:29
 */
public class ServiceException extends RuntimeException{
    public ServiceException(String msg){
        super(msg);
    }
}