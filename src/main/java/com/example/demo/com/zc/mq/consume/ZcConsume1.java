package com.example.demo.com.zc.mq.consume;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhangchi5 on 2018/12/11.
 */
@Component
@RabbitListener(queues = "zc")
public class ZcConsume1 {

    @RabbitHandler
    public void consume(String msg) {
        System.out.println("receive1: " + msg);
    }
}
