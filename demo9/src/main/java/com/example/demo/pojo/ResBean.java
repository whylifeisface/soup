package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResBean {
    private int code;
    private String message;
    private Object obj;
    private  HashMap<String, String> token;

    public static ResBean success(String message){
        return new ResBean(200, message,null,null);
    }

    public static ResBean success(String s, HashMap<String, String> tokenMap) {
        return new ResBean(200, s,null,tokenMap);
    }


    public ResBean success(int code, String message, Object obj){
        return new ResBean(200, message, obj,null);
    }

    public static ResBean error(String message){
        return new ResBean(500, message,null,null);
    }

    public ResBean error(int code, String message, Object obj){
        return new ResBean(500, message, obj,null);
    }
}
