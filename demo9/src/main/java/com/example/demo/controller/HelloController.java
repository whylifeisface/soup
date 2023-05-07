package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/hello", tags = "测试hello")
@RestController
public class HelloController {

    @ApiOperation("hello")
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}