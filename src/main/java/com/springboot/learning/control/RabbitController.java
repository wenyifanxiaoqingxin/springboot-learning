package com.springboot.learning.control;

import com.springboot.learning.common.rabbit.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fx on 2018/5/7.
 */
@Controller
@RequestMapping("/rabbit")
public class RabbitController {
    @Autowired
    private RabbitSender rabbitSender;
    @Autowired
    private RabbitSender rabbitSender1;


    @RequestMapping("/html")
    public String test(){

        return "rabbit";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public void hello(String sendMsg){
        rabbitSender.send(sendMsg);
    }
}
