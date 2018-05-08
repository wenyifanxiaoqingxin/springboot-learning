package com.springboot.learning.common.rabbit;

import com.springboot.learning.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/5/8.
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiverOne {
    @RabbitHandler
    public void process(User user){

        System.out.println("topic.message receive  : username is " + user.getUsername()+" and password is "+user.getPassword());
    }
}
