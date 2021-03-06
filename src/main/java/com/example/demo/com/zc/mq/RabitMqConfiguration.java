package com.example.demo.com.zc.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabitMq配置
 */
@Configuration
@Slf4j
public class RabitMqConfiguration {

    @Autowired
    private RabbitTemplate rabbitTemplate;



    @Bean
    public Queue queue() {
        return new Queue("zc");
    }

    /**
     38      * 定制化amqp模版
     39      *
     40      * ConfirmCallback接口用于实现消息发送到RabbitMQ交换器后接收ack回调   即消息发送到exchange  ack
     41      * ReturnCallback接口用于实现消息发送到RabbitMQ 交换器，但无相应队列与交换器绑定时的回调  即消息发送不到任何一个队列中  ack
     42      */
    /*@Bean
    public RabbitTemplate rabbitTemplate() {
        // 消息发送失败返回到队列中, yml需要配置 publisher-returns: true
        rabbitTemplate.setMandatory(true);

        // 消息确认, yml需要配置 publisher-confirms: true
        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> {
            if (ack) {
                log.warn("消息发送到exchange成功,id: {}", correlationData.getId());
            }else {
                log.warn("消息发送到exchange失败,原因: {}", cause);
            }
        }));

        // 消息返回, yml需要配置 publisher-returns: true
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            String correlationId = message.getMessageProperties().getCorrelationId();
            log.warn("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
        });
        return rabbitTemplate;
    }*/
}
