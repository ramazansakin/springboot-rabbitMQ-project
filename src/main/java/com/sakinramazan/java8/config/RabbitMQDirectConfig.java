package com.sakinramazan.java8.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

    @Bean
    Queue marketingQueue() {
        return new Queue("sampleQueue1", false);
    }

    @Bean
    Queue financeQueue() {
        return new Queue("sampleQueue2", false);
    }

    @Bean
    Queue adminQueue() {
        return new Queue("sampleQueue3", false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("direct-exchange");
    }

    @Bean
    Binding marketingBinding(Queue marketingQueue, DirectExchange exchange) {
        return BindingBuilder.bind(marketingQueue).to(exchange).with("sampleQueue1");
    }

    @Bean
    Binding financeBinding(Queue financeQueue, DirectExchange exchange) {
        return BindingBuilder.bind(financeQueue).to(exchange).with("sampleQueue2");
    }

    @Bean
    Binding adminBinding(Queue adminQueue, DirectExchange exchange) {
        return BindingBuilder.bind(adminQueue).to(exchange).with("sampleQueue3");
    }

}
