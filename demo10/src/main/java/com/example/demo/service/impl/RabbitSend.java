package com.example.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitSend {
    @Autowired
    private  RabbitTemplate rabbitTemplate;

    public  void MessageSend(String message){
        rabbitTemplate.convertAndSend("seckExchange","seck.message",message);
    }

}
