package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class TestRedis {
    @Autowired
    StringRedisTemplate template;

    @Test
    void testRsa(){
        ValueOperations<String, String> operations = template.opsForValue();
        operations.set("hello","world");
        String s = operations.get("hello");
        System.out.println(s);
    }
}
