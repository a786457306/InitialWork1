package com.xiaozl.initialwork1.web.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * FileController
 *
 * @author Daydreamer
 * @date 2017/12/15 18:56
 */
@Controller
@RequestMapping(value = "/file")//文件处理页面都在file文件夹里
public class FileController {

    /**
     * 去文件上传页面
     *
     * @return
     */
    @RequestMapping(value = "fileUpload", method = RequestMethod.GET)
    public String toFileUpload(){
        return "/file/fileUpload";
    }

    /**
     * 单个文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file")MultipartFile file){
        if (!file.isEmpty()){
            try {
                //存入F:\temp目录下
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File("F:\\temp",
                        System.currentTimeMillis()+ file.getOriginalFilename()));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        //上传成功，跳转至success页面
        return "file/success";
    }

    /**
     * 去多个文件上传页面
     *
     * @return
     */
    @RequestMapping(value = "multiFileUpload", method = RequestMethod.GET)
    public String toMultiFileUpload(){
        return "/file/multiFileUpload";
    }

    /**
     * 多个文件上传
     *
     * @param multiRequest
     * @return
     */
    @RequestMapping(value = "multiUpload", method = RequestMethod.POST)
    public String multiFileUpload(MultipartHttpServletRequest multiRequest) throws IOException {
        Iterator<String> filesNames = multiRequest.getFileNames(); //获得所有的文件名
        while(filesNames.hasNext()){    //迭代，对单个文件进行操作
            String fileName =filesNames.next();
            MultipartFile file =  multiRequest.getFile(fileName);
            if(!file.isEmpty()){
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File("F:\\temp",
                        System.currentTimeMillis()+ file.getOriginalFilename()));
            }

        }
        //上传成功，跳转至success页面
        return "file/success";
    }

//    /**
//     * 去文件下载页面
//     *
//     * @return
//     */
//    @RequestMapping(value = "fileDownload", method = RequestMethod.POST)
//    public String toFileDownload(){
//        return "/file/fileDownload";
//    }

    /**
     * 指定文件下载
     *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "download",produces = "application/octet-stream;charset=UTF-8")
    public ResponseEntity<byte[]> download() throws IOException {
//                指定文件,必须是绝对路径
        File file = new File("F:\\temp\\1513489657107psb.jpg");
//                下载浏览器响应的那个文件名
        String dfileName = "1.jpg";
//                下面开始设置HttpHeaders,使得浏览器响应下载
        HttpHeaders headers = new HttpHeaders();
//                设置响应方式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//                设置响应文件
        headers.setContentDispositionFormData("attachment", dfileName);
//                把文件以二进制形式写回
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
