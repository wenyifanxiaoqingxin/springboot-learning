package com.springboot.learning.control;

import com.springboot.learning.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.GeneralSecurityException;

/**
 * Created by fx on 2018/5/11.
 */
@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping("/send")
    @ResponseBody
    public String send(){

        String s = null;
        try {
            s = mailService.sendSimpleMail("1311083901@qq.com","this is a mail from me","sorry, i am fx ,thanks a lot");
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            s  = e.getMessage();
        }
        return s;
    }
}
