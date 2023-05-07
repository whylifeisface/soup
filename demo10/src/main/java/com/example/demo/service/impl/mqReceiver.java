package com.example.demo.service.impl;

import com.example.demo.Utils.JsonUtil;
import com.example.demo.model.SeckillMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class mqReceiver {
    @RabbitListener(queues = "Seckill")
    public void receive(String message){
        JsonUtil.fromJson(message, SeckillMessage.class);

    }
}
