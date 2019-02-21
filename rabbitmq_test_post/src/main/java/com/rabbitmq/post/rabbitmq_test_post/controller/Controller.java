package com.rabbitmq.post.rabbitmq_test_post.controller;

import com.rabbitmq.post.rabbitmq_test_post.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aisha on 21.02.2019.
 */

@RestController
@RequestMapping(value = "/rabbitmq_test/")
public class Controller {
    @Autowired
    RabbitMQService rabbitMQService;

    @GetMapping(value = "/post")
    public String post(@RequestParam("message") String message, @RequestParam("count") int count)throws InterruptedException{
        rabbitMQService.send(message,count);
        return "Successfully sent " + message + " count " + count + "time!";
    }
}
