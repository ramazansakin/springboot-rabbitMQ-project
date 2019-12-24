package com.sakinramazan.java8.controller;

import com.sakinramazan.java8.model.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exchange/")
public class RabbitMQDirectWebController {

    @Autowired
    private AmqpTemplate amqpTemplate;

//    Version - 2 for DLQ
    @GetMapping(value = "/producer")
    public String producer(@RequestParam("sName") String sName, @RequestParam("sId") String sId, @RequestParam("schoolName") String schoolName) {
        Student student = new Student();
        student.setsName(sName);
        student.setsId(sId);
        student.setSchoolName(schoolName);

        amqpTemplate.convertAndSend("sampleExchange", "sampleRabbitMQ", student);

        return "Message sent to the RabbitMQ Successfully";
    }
}