package com.rabbitmq.tutorial.rabbitmq_comsumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.tutorial.rabbitmq_comsumer.model.Employee;
/**
 * Created by Aisha on 20.02.2019.
 */
@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "${tutorial.rabbitmq.queue}")
    public void recievedMessage(Employee employee) {
        System.out.println("Recieved Message From RabbitMQ: " + employee);
    }
}
