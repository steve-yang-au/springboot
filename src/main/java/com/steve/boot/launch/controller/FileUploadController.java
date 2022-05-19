package com.steve.boot.launch.controller;

import com.steve.boot.launch.config.minio.MinIOTemplate;
import com.steve.boot.launch.model.MinIOProperties;
import io.minio.errors.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {

    @Resource
    private MinIOProperties minIo;
    @Resource
    MinIOTemplate minTemplate;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile,
                         HttpServletRequest request) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {


        if(!minTemplate.bucketExists("test")){
            minTemplate.makeBucket("test");
        }

        // 在 uploadPath 文件夹中通过日期对上传的文件归类保存
        // 比如：/2019/06/06/cf13891e-4b95-4000-81eb-b6d70ae44930.png
        String folder = sdf.format(new Date());
        // 对上传的文件重命名，避免文件重名
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString()
                + oldName.substring(oldName.lastIndexOf("."), oldName.length());


        // 文件保存
        minTemplate.putObject("test",folder + newName, uploadFile.getInputStream());


        // 返回上传文件的访问路径
        //https://localhost:8888/2020/10/18/a9a05df4-6615-4bb5-b859-a3f9bf4bfae0.jpg
        String filePath = minIo.getEndpoint() + "/test/" + folder + newName;
        return filePath;
    }

}
