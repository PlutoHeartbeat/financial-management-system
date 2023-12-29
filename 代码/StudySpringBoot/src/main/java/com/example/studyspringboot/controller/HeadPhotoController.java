package com.example.studyspringboot.controller;

import cn.hutool.core.io.FileUtil;
import com.example.studyspringboot.commont.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 功能：
 * 作者：熊奎
 * 日期：2023/11/13 18:58
 */
@RestController
@RequestMapping("/headPhoto")
public class HeadPhotoController {
    @Value("${ip: localhost}")
    String ip;
    @Value("${server.port}")
    String port;
    // 存储头像文件的路径
    private static final String HEAD_PHOTO_PATH = System.getProperty("user.dir") + File.separator + "headPhoto";
    SimpleDateFormat sdf = null;

    @PostMapping("/upload")
    public Result uploadHeadPhoto(MultipartFile file) throws IOException {
        if (file == null) {
            return Result.error("上传文件为空");
        }
        String originalFilename = file.getOriginalFilename();
        String mainName = FileUtil.mainName(originalFilename);
        String extName = FileUtil.extName(originalFilename);

        // 获取当前的年月日时分秒作为文件名前缀
        sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());

        // 构建新的文件名
        String newFilename = timestamp + "_" + mainName + "." + extName;

        // 检查头像文件存储目录是否存在，不存在则创建
        if (!FileUtil.exist(HEAD_PHOTO_PATH)) {
            FileUtil.mkdir(HEAD_PHOTO_PATH);
        }

        // 存储文件到头像文件目录
        File saveFile = new File(HEAD_PHOTO_PATH + File.separator + newFilename);
        file.transferTo(saveFile);

        // 返回头像文件的URL
        String url = "http://" + ip + ":" + port + "/headPhoto/download/" + newFilename;

        return Result.success(url);
    }

    @GetMapping("/download/{filename}")
    public void downloadHeadPhoto(@PathVariable String filename, HttpServletResponse response) throws IOException {
        response.addHeader("Content-Disposition", "inline;filename=" + URLEncoder.encode(filename, "UTF-8"));
        String filePath = HEAD_PHOTO_PATH + File.separator + filename;

        if (!FileUtil.exist(filePath)) {
            return;
        }

        byte[] bytes = FileUtil.readBytes(filePath);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }
    /**
     * 查询全部凭证
     * @return
     * @throws IOException
     */
    @GetMapping("/list")
    public List<List<String>> listFiles() throws IOException {
        List<List<String>> fileInfos = new ArrayList<>();
        File rootDirectory = new File(HEAD_PHOTO_PATH);

        if (rootDirectory.exists() && rootDirectory.isDirectory()) {
            File[] files = rootDirectory.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    String filename = file.getName();
                    String url = "/static/" + filename;
                    List<String> fileInfo = new ArrayList<>();
                    fileInfo.add(url);
                    fileInfo.add(filename);
                    fileInfos.add(fileInfo);
                }
            }
        }
        return fileInfos;
    }
}