package com.springboot.learning.common.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/5/8.
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverTwo {

    @RabbitHandler
    public void process(String msg){

        System.out.println("FanoutReceiverTwo receive is" + msg);
    }
}
