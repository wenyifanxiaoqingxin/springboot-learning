package com.springboot.learning.common.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/5/8.
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverOne {

    @RabbitHandler
    public void process(String msg){

        System.out.println("FanoutReceiverOne receive is" + msg);
    }
}
