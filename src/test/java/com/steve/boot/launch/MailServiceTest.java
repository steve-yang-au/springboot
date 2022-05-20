package com.steve.boot.launch;

import com.steve.boot.launch.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.mail.MessagingException;

//用配置文件的指定端口DEFINED_PORT作为启动端口运行测试用例
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MailServiceTest {

    @Resource
    MailService mailService;

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("steve.yang.au@gmail.com",
                "普通文本邮件",
                "普通文本邮件内容测试");
    }

    @Test
    public void sendHtmlMail() throws MessagingException {
        mailService.sendHtmlMail("steve.yang.au@gmail.com","一封html测试邮件","<body style=\"text-align: center;margin-left: auto;margin-right: auto;\">\n"
                + " <div id=\"welcome\" style=\"text-align: center;position: absolute;\" >\n"
                +"      <h3>\"一封html测试邮件\"</h3>\n"
                +"      <span>http://www.zimug.com</span>"
                + "     <div style=\"text-align: center; padding: 10px\"><a style=\"text-decoration: none;\" href=\"https://zimug.com\" target=\"_bank\" >"
                + "           <strong>我很用心，希望你有所收获</strong></a></div>\n"
                + " </div>\n" + "</body>");
    }

    @Test
    public void sendAttachmentsMailTest() throws MessagingException {
        String filePath = "E:\\static\\Steve Mingshan Yang_Resume_Java_24Mar2022.docx";
        mailService.sendAttachmentsMail("steve.yang.au@gmail.com",
                "这是一封带附件的邮件", "邮件中有附件，请注意查收！",
                filePath);
    }

    @Test
    public void sendResourceMail() throws MessagingException {
        String rscId = "STEVE";
        String content = "<html><body>这是有图片的邮件<br/><img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "E:\\static\\favicon.ico.png";
        mailService.sendResourceMail("steve.yang.au@gmail.com",
                "这邮件中含有图片",
                content,
                imgPath,
                rscId);

    }
}
