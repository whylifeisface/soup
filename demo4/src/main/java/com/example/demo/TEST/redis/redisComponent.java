package com.example.demo.TEST.redis;


import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class redisComponent {
    private final StringRedisTemplate template;


    public redisComponent(StringRedisTemplate template) {
        this.template = template;
    }
}
