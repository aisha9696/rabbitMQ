package com.rabbitmq.post.rabbitmq_test_post.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Aisha on 21.02.2019.
 */
@Configuration
public class RabbitMqConfig {

    @Value("${test.rabbitmq.queue}")
    String queueName;

    @Value("${test.rabbitmq.exchange}")
    String exchange;

    @Value("${test.rabbitmq.routingkey}")
    private String routingkey;

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }


}