package com.rabbitmq.post.rabbitmq_test_post.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Aisha on 21.02.2019.
 */

@Service
public class RabbitMQService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${test.rabbitmq.exchange}")
    private String exchange;

    @Value("${test.rabbitmq.routingkey}")
    private String routingkey;

    public void send(String msg, int count) throws InterruptedException{
        for (int i=0; i < count; i++){
            rabbitTemplate.convertAndSend(exchange, routingkey, msg + " " + i);
            Thread.sleep(5000);
            System.out.println("Now sending " +i + "message!");
        }
        System.out.print("All sent!");

    }
}
