package com.example.studyspringboot.controller;

import cn.hutool.core.util.StrUtil;
import com.example.studyspringboot.Service.UserService;
import com.example.studyspringboot.commont.Result;
import com.example.studyspringboot.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 提供接口返回数据
 * @author mochenshusheng
 */
@RestController
public class WebController {

    @Resource
    UserService userService;

    @RequestMapping(path = "/")
    public Result hello() {
        return Result.success("success");
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        if(StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())){
            return Result.error("数据输入不合法");
        }
        user = userService.login(user);
        return Result.success(user);
    }
    /**
     * 重置密码
     * @param user 前端输入的用户信息
     * @return 修改结果
     */
    @PutMapping("/password")
    public Result password(@RequestBody User user) {
        if(StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPhone())){
            return Result.error("数据输入不合法");
        }
        userService.resetPassword(user);
        return Result.success();
    }
}
