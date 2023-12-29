package com.example.studyspringboot.controller;

import com.example.studyspringboot.Service.NoticeService;
import com.example.studyspringboot.commont.Result;
import com.example.studyspringboot.entity.Notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 功能：
 * 作者：熊奎
 * 日期：2023/11/12 22:09
 * @author mochenshusheng
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @PostMapping("/create")
    public Result createNotice(@RequestBody Notice notice) {
        try {
            String title = notice.getTitle();
            String content = notice.getContent();

            if (title == null || content == null) {
                return Result.error("title 和 content 字段是必需的");
            }
            // 执行创建通知的业务逻辑
            /*Notice createdNotice = noticeService.createNotice(request);*/
            noticeService.insert(notice);
            return Result.success("创建成功");
        } catch (Exception e) {
            return Result.error("创建通知失败：" + e.getMessage());
        }
    }

    @GetMapping("/get")
    public Result getAllNotices() {
        try {
            // 获取所有通知的业务逻辑
            List<Notice> notices = noticeService.getAllNotices();
            return Result.success(notices);
        } catch (Exception e) {
            return Result.error("获取通知失败：" + e.getMessage());
        }
    }
}
