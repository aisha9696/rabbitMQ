package com.rabbitmq.read.rabbitmq_test_read.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Aisha on 21.02.2019.
 */

@Component
public class Consumer {

    @RabbitListener(queues = "${test.rabbitmq.queue}")
    public void receivedMessage(String msg) {
        System.out.println("Received Message From RabbitMQ: " + msg);
    }

}
