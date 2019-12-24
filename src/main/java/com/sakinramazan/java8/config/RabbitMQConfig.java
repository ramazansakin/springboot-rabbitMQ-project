package com.sakinramazan.java8.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${samplerabbitmq.rabbitmq.queue}")
    String queueName;

    @Value("${samplerabbitmq.rabbitmq.exchange}")
    String exchange;

    @Value("${samplerabbitmq.rabbitmq.routingkey}")
    private String routingkey;

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

    @Bean
    DirectExchange deadLetterExchange() {
        return new DirectExchange("deadLetterExchange");
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("javainuseExchange");
    }

    @Bean
    Queue dlq() {
        return QueueBuilder.durable("deadLetter.queue").build();
    }

    @Bean
    Queue queue() {
        return QueueBuilder.durable("samplerabbitmq.queue").withArgument("x-dead-letter-exchange", "deadLetterExchange")
                .withArgument("x-dead-letter-routing-key", "deadLetter").build();
    }

    @Bean
    Binding DLQbinding() {
        return BindingBuilder.bind(dlq()).to(deadLetterExchange()).with("deadLetter");
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with("samplerabbitmq.routingkey");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
