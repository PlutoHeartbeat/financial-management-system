package com.example.studyspringboot.commont;

import lombok.*;

/**
 * 功能：操作或请求的结果
 * 作者：熊奎
 * 日期：2023/11/8 18:40
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {
    // 声明常量：成功、身份验证错误和系统错误的结果代码

    public static final String CODE_SUCCESS = "200";
    public static final String CODE_AUTH_ERROR = "401";
    public static final String CODE_SYS_ERROR = "500";
    // 结果类的字段如下：
    // 结果代码，错误的详细信息
    // 结果消息
    //结果数据
    private String code;
    private String msg;
    private Object data;

    /**
     * 静态工厂方法：创建成功的结果，没有额外数据
     */
    public static Result success() {
        return new Result(CODE_SUCCESS, "请求成功", null);
    }

    /**
     * 静态工厂方法：创建成功的结果，带有额外数据
     */
    public static Result success(Object data) {
        return new Result(CODE_SUCCESS, "请求成功", data);
    }
    /**
     * 静态工厂方法：创建错误的结果，使用默认的系统错误代码
     */
    public static Result error(String msg) {
        return new Result(CODE_SYS_ERROR, msg, null);
    }
    /**
     * 静态工厂方法：创建错误的结果，使用指定的错误代码和错误消息
     */
    public static Result error(String code, String msg) {
        return new Result(code, msg, null);
    }
    /**
     * 静态工厂方法：创建默认的系统错误结果
     */
    public static Result error() {
        return new Result(CODE_SYS_ERROR, "系统错误", null);
    }
}