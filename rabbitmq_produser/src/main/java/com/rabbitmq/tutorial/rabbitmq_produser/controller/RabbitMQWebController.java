package com.rabbitmq.tutorial.rabbitmq_produser.controller;

/**
 * Created by Aisha on 20.02.2019.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.tutorial.rabbitmq_produser.model.Employee;
import com.rabbitmq.tutorial.rabbitmq_produser.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/tutorial-rabbitmq/")
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {

        Employee emp=new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        rabbitMQSender.send(emp);

        return "Message sent to the RabbitMQ Successfully";
    }

}
