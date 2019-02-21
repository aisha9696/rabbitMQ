package com.rabbitmq.tutorial.rabbitmq_produser.service;

/**
 * Created by Aisha on 20.02.2019.
 */
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbitmq.tutorial.rabbitmq_produser.model.Employee;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${tutorial.rabbitmq.exchange}")
    private String exchange;

    @Value("${tutorial.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee company) {
        rabbitTemplate.convertAndSend(exchange, routingkey, company);
        System.out.println("Send msg = " + company);

    }
}
