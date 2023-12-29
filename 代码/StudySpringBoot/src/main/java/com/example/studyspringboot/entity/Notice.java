package com.example.studyspringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**通知公告实体类
 * @author mochenshusheng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("notice")
public class Notice {
  @TableId(type= IdType.AUTO)
  private int noticeId;
  private String title;
  private String content;
  private java.sql.Timestamp publishDate;
}
