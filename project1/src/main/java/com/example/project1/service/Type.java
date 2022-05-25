package com.example.project1.service;

import com.example.project1.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Type {

    @Autowired
    TypeMapper typeMapper;

    public com.example.project1.pojo.Type TypeC(String s){
        return typeMapper.selectClassification(s);
    }
}
