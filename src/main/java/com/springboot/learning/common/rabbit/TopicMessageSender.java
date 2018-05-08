package com.springboot.learning.common.rabbit;

import com.springboot.learning.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/5/8.
 */
@Component
public class TopicMessageSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(User user){

        System.out.println("user send1 is username:" + user.getUsername()+"/userpassword:"+user.getPassword());
        this.amqpTemplate.convertAndSend("exchange","topic.message",user);

        System.out.println("user send2 is username:" + user.getUsername()+"/userpassword:"+user.getPassword());
        this.amqpTemplate.convertAndSend("exchange","topic.messages",user);
    }
}
