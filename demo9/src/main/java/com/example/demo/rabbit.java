package com.example.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbit {
    private static final String  Queue = "Secmes";
    private static final String Exchange = "SeckillExchange";

    @Bean
    public Queue queue(){
        return new Queue(Queue);
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(Exchange);
    }
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(topicExchange()).with("seck.#");
    }

}
