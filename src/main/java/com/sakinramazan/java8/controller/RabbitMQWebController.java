package com.sakinramazan.java8.controller;

import com.sakinramazan.java8.model.Student;
import com.sakinramazan.java8.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sample-rabbitmq")
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("sName") String sName, @RequestParam("sId") String sId) {

        Student student = new Student();
        student.setsName(sName);
        student.setsId(sId);
        rabbitMQSender.send(student);

        return "Message sent to the RabbitMQ Successfully";
    }

}

