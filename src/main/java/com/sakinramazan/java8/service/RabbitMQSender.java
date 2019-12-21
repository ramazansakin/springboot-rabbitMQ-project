package com.sakinramazan.java8.service;

import com.sakinramazan.java8.model.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${samplerabbitmq.rabbitmq.exchange}")
    private String exchange;

    @Value("${samplerabbitmq.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Student company) {
        amqpTemplate.convertAndSend(exchange, routingkey, company);
        System.out.println("Send msg = " + company);
    }
}