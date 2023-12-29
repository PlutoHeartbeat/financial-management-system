package com.example.studyspringboot.entity;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
/**
 * 用户实体类
 * @author mochenshusheng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")

public class User {
  @TableId(type= IdType.AUTO)
  @Alias("序号")
  private int id;
  @Alias("用户名")
  private String username;
  @Alias("密码")
  private String password;
  @Alias("姓名")
  private String name;
  @Alias("手机号")
  private String phone;
  @Alias("邮箱")
  private String email;
  @Alias("地址")
  private String address;
  @Alias("头像")
  private String avatar;
  @Alias("角色")
  private String role;
}