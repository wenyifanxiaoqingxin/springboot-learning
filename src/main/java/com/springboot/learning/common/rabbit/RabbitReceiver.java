package com.springboot.learning.common.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/5/7.
 */
@Component
@RabbitListener(queues = "helloQueue")
public class RabbitReceiver {
    @RabbitHandler
    public void process(String hello){

        System.out.println("Receiver: "+hello);
    }
}
