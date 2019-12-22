package com.sakinramazan.java8;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootHelloWorldApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                new Object[]{SpringBootHelloWorldApplication.class}, args);
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

}