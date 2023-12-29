package com.example.studyspringboot.controller;

import java.util.Date;
import cn.hutool.core.io.FileUtil;
import com.example.studyspringboot.commont.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能：
 * 作者：熊奎
 * 日期：2023/11/10 17:35
 */
@RestController
@RequestMapping("/file")
public class FileController {
    //单个文件的上传
    @Value("${ip: localhost}")
    String ip;
    @Value("${server.port}")
    String port;
    private static final String ROOT_PATH =  System.getProperty("user.dir") + File.separator + "files";
    SimpleDateFormat sdf = null;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException{
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

        if (!FileUtil.exist(ROOT_PATH)) {
            FileUtil.mkdir(ROOT_PATH);
        }
        // 存储文件到本地的磁盘里面
        File saveFile = new File(ROOT_PATH + File.separator + newFilename);
        file.transferTo(saveFile);
        String url = "http://" + ip + ":" + port + "/file/download/" + newFilename;

        return Result.success(url);
    }
    //单个文件的下载
    @GetMapping("/download/{filename}")
    // filename,需要下载的文件名称以文件流的形式写出来,
    public void download(@PathVariable String filename, HttpServletResponse response) throws IOException {
        // 附件下载，默认是预览
        //response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        //附件预览
        response.addHeader("Content-Disposition", "inline;filename=" + URLEncoder.encode(filename, "UTF-8"));
        String filePath =  ROOT_PATH + File.separator + filename;
        if(!FileUtil.exist(filePath)){
            return;
        }
        byte[] bytes = FileUtil.readBytes(filePath);
        ServletOutputStream outputStream = response.getOutputStream();
        //数组是一个字节数组，也就是文件的字节流数组,通过outputStream写出去
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
        File rootDirectory = new File(ROOT_PATH);
        if (rootDirectory.exists() && rootDirectory.isDirectory()) {
            File[] files = rootDirectory.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    String filename = file.getName();
                    String url = "/file/download/" + filename;
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