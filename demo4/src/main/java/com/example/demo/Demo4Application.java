package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class Demo4Application {

    public static void main(String[] args) {
          SpringApplication.run(Demo4Application.class, args);
//        ConfigurableListableBeanFactory beanFactory = run.getBeanFactory();
//        System.out.println(beanFactory);
    }

}
