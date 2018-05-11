package com.springboot.learning.service.impl;

import com.springboot.learning.service.MailService;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * Created by fx on 2018/5/11.
 */
@Service
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private String port;

    @Value("${spring.mail.smtp.auth}")
    private String auth;


    @Override
    public String  sendSimpleMail(String to, String subject, String content) throws GeneralSecurityException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);


        //获取系统属性
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host",host);
        properties.setProperty("mail.smtp.port",port);
        properties.put("mail.smtp.auth",auth);

        MailSSLSocketFactory sf = new MailSSLSocketFactory();

        sf.setTrustAllHosts(true);

        properties.put("mail.smtp.ssl.enable","true");

        properties.put("mail.smtp.ssl.socketFactory",sf);
        //获取session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //qq邮箱生成授权码
                return new PasswordAuthentication("1311083901@qq.com","yzdginhtjaaoiedg");//发件人邮箱密码
            }
        });
        mailSender.setSession(session);
        try {
            mailSender.send(simpleMailMessage);
            System.out.println("send success");
            return "success";
        }catch (Exception e){

           e.getStackTrace();
            System.out.println("send failed:"+e.getMessage());
            return "failed"+e.getMessage();
        }

    }
}
