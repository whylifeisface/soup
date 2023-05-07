package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Bean {
    String  code;
    List<Object> data;


    public Bean(String s, List<TGoods> staticAll) {

    }
}
