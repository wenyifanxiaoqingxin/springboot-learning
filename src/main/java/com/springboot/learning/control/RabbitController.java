package com.springboot.learning.control;

import com.springboot.learning.common.rabbit.FanoutSender;
import com.springboot.learning.common.rabbit.RabbitSender;
import com.springboot.learning.common.rabbit.TopicMessageSender;
import com.springboot.learning.entity.User;
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
    private TopicMessageSender topicMessageSender;
    @Autowired
    private FanoutSender fanoutSender;

    @RequestMapping("/html")
    public String test(){

        return "rabbit";
    }
    //一对一
    @RequestMapping("/hello")
    @ResponseBody
    public void hello(String sendMsg){
        rabbitSender.send(sendMsg);
    }
    //一对多 一个生产者多个接受者  接受者分别接受
    @RequestMapping("/onetomany")
    @ResponseBody
    public void onetomany(String sendMsg){
        rabbitSender.sendMany(sendMsg);
    }


    //主题topic发送对象
    @RequestMapping("/userTopicSend")
    @ResponseBody
    public void userTopicSend(User user){
        topicMessageSender.send(user);
    }

    //广播发送消息 绑定fanoutExchane的队列都会收到
    @RequestMapping("/fanoutSend")
    @ResponseBody
    public void fanoutSend(String  msg){
        fanoutSender.send(msg);
    }
}
