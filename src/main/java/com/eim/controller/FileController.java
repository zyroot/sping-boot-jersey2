package com.eim.controller;

import com.eim.utils.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/10/31.
 */
@Controller
public class FileController {

    private final String  aliUrl = "http://app.i-mineral.cn/web_save/upload/";
    private final String  localUrl = "http://localhost:8080/babasport/res/";

    @ResponseBody
    @PostMapping("/upload")
    public String uploda(MultipartFile multipartFile, HttpServletRequest request){
        System.out.println("dd");
        String url = aliUrl;
        String resultUrl = FileUploadUtil.fileUp(multipartFile, url);
        if(!StringUtils.isEmpty(resultUrl)){
            System.out.println("上传成功:"+resultUrl);
        }

        return  "成功";
    }
}
