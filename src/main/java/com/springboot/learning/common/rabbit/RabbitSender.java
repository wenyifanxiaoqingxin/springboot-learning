package com.springboot.learning.common.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by fx on 2018/5/7.
 */
@Component
public class RabbitSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg){

        String sendMsg = " hello1! i want send "+msg+ new Date();
        System.out.println("Sender1: "+sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue",sendMsg);
    }
}
