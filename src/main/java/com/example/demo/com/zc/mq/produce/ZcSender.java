package com.example.demo.com.zc.mq.produce;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhangchi5 on 2018/12/11.
 */
@Component
public class ZcSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        System.out.println("生产消息：" + msg);
        rabbitTemplate.convertAndSend("zcExchange","zcRouteKey","");
        rabbitTemplate.convertAndSend("zc",msg + "1");
        rabbitTemplate.convertAndSend("zc",msg + "2");
    }
}
