package com.example.studyspringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")

public class SysUser {
  @TableId(type= IdType.AUTO)
  private long userId;
  private long deptId;
  private String userName;
  private String nickName;
  private String userType;
  private String email;
  private String phonenumber;
  private String sex;
  private String avatar;
  private String password;
  private String status;
  private String delFlag;
  private String loginIp;
  private java.sql.Date loginDate;
}
