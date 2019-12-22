package com.sakinramazan.java8.service;

import com.sakinramazan.java8.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

//    @RabbitListener(queues = "${samplerabbitmq.rabbitmq.queue}")
//    public void recievedMessage(Student student) {
//        System.out.println("Message from rabbitMQ - Student ==> : " + student);
//    }

    @RabbitListener(queues = "samplerabbitmq.rabbitmq.queue")
    public void recievedMessage(Student student) throws Exception {
        if (student.getSchoolName().isEmpty()) {
            throw new Exception("Invalid School Name!");
        }

        logger.info("Incoming Message on RabbitMQ: " + student);
    }

}
