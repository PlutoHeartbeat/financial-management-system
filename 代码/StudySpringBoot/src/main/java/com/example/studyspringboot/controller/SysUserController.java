package com.example.studyspringboot.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.studyspringboot.Service.SysUserService;

import com.example.studyspringboot.commont.Result;
import com.example.studyspringboot.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.net.URLEncoder;

/**
 * 功能：
 * 作者：熊奎
 * 日期：2023/11/12 14:55
 */
@CrossOrigin
@RestController
@RequestMapping("/system")
public class SysUserController {
    /**
     * 获取数据库的信息，Autowired注解，从Spring容器容器中获取userService的bean实例
     * 通过这个实例去调用方法
     */
    @Autowired
    SysUserService sysUserService;
    @PostMapping("/addUser")
    public Result add(@RequestBody SysUser sysUser){
        try {
            sysUserService.save(sysUser);
        }catch (Exception e){
            if(e instanceof DuplicateKeyException){
                return Result.error("插入数据库错误");
            }else {
                return Result.error("系统错误");
            }
        }
        return Result.success();
    }
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping("/updateUser")
    public Result updata(@RequestBody SysUser user){
        sysUserService.updateById(user);
        return Result.success();
    }
    /**
     * 单个删除
     * @param id
     * @return
     */
    @DeleteMapping("/delUser/{id}")
    public Result delete(@PathVariable int id){
        sysUserService.removeById(id);
        return Result.success();
    }
    /**
     * 批量删除用户信息
     */
    @DeleteMapping("/delete/batch")
    public Result batchDelete(@RequestBody List<Integer> ids) {
        sysUserService.removeBatchByIds(ids);
        return Result.success();
    }

    /**
     * 查询全部用户信息
     */
    @GetMapping("/listUser")
    public Result selectAll() {
        List<SysUser> userList = sysUserService.list(new QueryWrapper<SysUser>().orderByDesc("user_id"));
        return Result.success(userList);
    }
    /**
     * 根据ID查询用户信息
     */
    @GetMapping("/getUser/{id}")
    public Result selectById(@PathVariable Integer id) {
        SysUser user = sysUserService.getById(id);
        return Result.success(user);
    }
    /**
     * 多条件分页模糊查询用户信息
     * pageNum 当前的页码
     * pageSize 每页查询的个数
     */
    @GetMapping("/selectByPage")
    public Result selectByPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam String username,
                               @RequestParam String name) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().orderByDesc("id");
        queryWrapper.like(StrUtil.isNotBlank(username),"username",username);
        queryWrapper.like(StrUtil.isNotBlank(username),"name",name);
        Page<SysUser> page = sysUserService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return Result.success(page);
    }

    /**
     *
     * @param username
     * @param name
     * @param ids
     * @param response
     * @throws IOException
     */
    @GetMapping("/export")
    public void exportData(@RequestParam(required = false) String username,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String ids,  //   1,2,3,4,5
                           HttpServletResponse response) throws IOException {
        ExcelWriter writer = ExcelUtil.getWriter(true);

        List<SysUser> list;
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        // ["1", "2", "3"]   => [1,2,3]
        if (StrUtil.isNotBlank(ids)) {
            List<Integer> idsArr1 = Arrays.stream(ids.split(",")).map(Integer::valueOf).collect(Collectors.toList());
            queryWrapper.in("id", idsArr1);
        } else {
            // 第一种全部导出或者条件导出
            queryWrapper.like(StrUtil.isNotBlank(username), "username", username);
            queryWrapper.like(StrUtil.isNotBlank(name), "name", name);
        }
        // 查询出当前User表的所有数据
        list = sysUserService.list(queryWrapper);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("用户信息表", "UTF-8") + ".xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        writer.flush(outputStream, true);
        writer.close();
        outputStream.flush();
        outputStream.close();
    }
}