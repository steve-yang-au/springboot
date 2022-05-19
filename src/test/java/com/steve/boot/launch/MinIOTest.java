package com.steve.boot.launch;

import com.steve.boot.launch.config.minio.MinIOTemplate;
import io.minio.ObjectWriteResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MinIOTest {

    @Resource
    MinIOTemplate minTemplate;

    //测试创建bucket
    @Test
    void testCreateBucket() throws Exception {
        minTemplate.makeBucket("test");
    }

    //测试上传文件对象
    @Test
    void testPutObject() throws Exception {
        ObjectWriteResponse response = minTemplate.putObject("test",
                "base/favicon.ico.png",
                "E:\\static\\favicon.ico.png");
        System.out.println(response.object());
    }

    //测试删除文件对象
    @Test
    void testDeleteObject() throws Exception {
        minTemplate.removeObject("test",
                "base/favicon.ico.png");
    }
}
