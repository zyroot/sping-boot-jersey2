package com.eim.utils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Administrator on 2018/10/31.
 */
public class FileUploadUtil {

    /**
     * @param multipartFile 文件
     * @param toPath  发送的位置url
     * @return 成功返回路径，不成功返回null
     */
    public static String fileUp(MultipartFile multipartFile,String toPath){
        Client client = new Client();
        //获取唯一键
        String uniqunceKey = KeyUtil.getUniqunceKey();
        String contentType = multipartFile.getContentType();
        String[] split = contentType.split("/");
        //获取类型
        String ext = split[1];
        String  fileName = uniqunceKey +"."+ext+".do";
        String url = toPath + fileName;
        try {

            WebResource resource = client.resource(url);
            if(multipartFile != null){
                resource.put(String.class,multipartFile.getBytes());
            }
            return url;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
