package com.example.project1.controller;

import com.example.project1.mapper.TypeMapper;
import com.example.project1.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//public class test {
//    @Autowired
//    private TypeMapper typeMapper;
//
//    @GetMapping("hello")
//    public List<Type> hello(){
//
//        return typeMapper.selectClassification("玄幻");
//    }
//}
