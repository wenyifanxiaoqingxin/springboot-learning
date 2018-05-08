package com.springboot.learning.common.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/5/8.
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public  void send(String msg){

        String message = "fanoutSender: i want tell you"+msg;

        System.out.println(message);
        this.amqpTemplate.convertAndSend("fanoutExchange","aaaa",message);
    }
}
