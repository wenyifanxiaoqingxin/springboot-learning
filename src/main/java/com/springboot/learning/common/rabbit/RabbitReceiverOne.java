package com.springboot.learning.common.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/5/7.
 */
@Component
@RabbitListener(queues = "helloQueues")
public class RabbitReceiverOne {
    @RabbitHandler
    public void process(String hello){

        System.out.println("ReceiverOne: "+hello);
    }
}
