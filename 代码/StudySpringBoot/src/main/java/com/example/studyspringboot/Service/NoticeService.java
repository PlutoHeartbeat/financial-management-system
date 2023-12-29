package com.example.studyspringboot.Service;

import java.io.IOException;
import java.sql.Timestamp;
import com.example.studyspringboot.entity.Notice;
import com.example.studyspringboot.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 * 功能：
 * 作者：熊奎
 * 日期：2023/11/13 0:18
 */
@Service
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    // 创建一个Jackson ObjectMapper
    private ObjectMapper objectMapper = new ObjectMapper();

    public Notice createNotice(String jsonData) {
        try {
            // 解析JSON数据
            Notice newNotice = objectMapper.readValue(jsonData, Notice.class);
            // 设置发布日期
            newNotice.setPublishDate(new Timestamp(System.currentTimeMillis()));
            // 插入通知数据到数据库
            noticeMapper.insert(newNotice);
            return newNotice;
        } catch (IOException e) {
            e.printStackTrace();
            // 处理解析JSON出错的情况
            return null;
        }
    }
    public List<Notice> getAllNotices() {
        // 查询所有通知数据
        return noticeMapper.selectList(null);
    }
    public  int insert(Notice notice){
       return noticeMapper.insert(notice);
    }
}
