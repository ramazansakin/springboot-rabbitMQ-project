package com.sakinramazan.java8.service;

import com.sakinramazan.java8.model.Student;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "${samplerabbitmq.rabbitmq.queue}")
    public void recievedMessage(Student student) {
        System.out.println("Message from rabbitMQ - Student ==> : " + student);
    }
}
