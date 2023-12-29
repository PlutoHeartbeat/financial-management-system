package com.example.studyspringboot.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.studyspringboot.entity.SysUser;
import com.example.studyspringboot.entity.User;
import com.example.studyspringboot.exception.ServiceException;
import com.example.studyspringboot.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 功能：
 * 作者：熊奎
 * 日期：2023/11/12 14:42
 */
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {
    @Resource
    SysUserMapper sysUserMapper;

    public SysUser selectByUsername(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        //根据用户名查询用户的信息
        return  getOne(queryWrapper);
    }
    /**
     * 验证用户账户是否合法
     * @return
     */
    public SysUser login(User user) {
        SysUser dbUser = selectByUsername(user.getUsername());
        if(dbUser == null){
            //抛出一个自定义异常
            throw new ServiceException("用户名或密码错误");
        }
        if (!Objects.equals(user.getPassword(), dbUser.getPassword())){
            throw new ServiceException("用户名或密码错误");
        }
        return dbUser;
    }

    /**
     * 重置密码
     * @param user
     */
    public void resetPassword(User user) {
        SysUser dbUser = selectByUsername(user.getUsername());
        if(dbUser == null){
            //抛出一个自定义异常
            throw new ServiceException("用户不存在");
        }
        if (!user.getPhone().equals(dbUser.getPhonenumber())) {
            throw new ServiceException("验证错误");
        }
        //重置的默认密码是123
        dbUser.setPassword("123");
        updateById(dbUser);
    }
}