package com.example.mybatisplusboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatisplusboot.pojo.User")
public class MybatisplusBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(MybatisplusBootApplication.class, args);
    }

}
