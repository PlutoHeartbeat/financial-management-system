package com.example.studyspringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 凭证实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("voucher")
public class Voucher {

  @TableId(type= IdType.AUTO)
  private int id;
  private String tiyle;
  private String content;
}
