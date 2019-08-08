package com.neuedu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {

    @RequestMapping(value = "/upload" ,method = RequestMethod.POST)
    public String upload(@RequestParam("picfile") MultipartFile uploadFile){


        if (uploadFile!=null){
            //UUID生成没有重复的字符串
            String uuid=UUID.randomUUID().toString();
            //uuid+扩展名，怎么获取扩展名
            String fileName=uploadFile.getOriginalFilename();
            System.out.println("======fileName"+fileName);

            //获取扩展名
            String fileextendname =fileName.substring(fileName.lastIndexOf("."));
            String newFileName=uuid+fileextendname;
            System.out.println("=========新的名称"+newFileName);

            //将文件保存在该目录下
            File file=new File("F:\\shixun\\upload");
            if (!file.exists()){
                file.mkdir();
            }
            File newFile=new File(file,newFileName);
            try {
                //将文件写入到磁盘中
                uploadFile.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return "upload";
    }
    @RequestMapping(value = "/upload" ,method = RequestMethod.GET)
    public String upload(){
        return "upload";
    }
}
