package com.example.pixiv.model.Base;

import lombok.Data;

@Data
public class BaseInterface {
    private int code;
    private String Message;
    private Object data;

    public BaseInterface(int code, String message, Object data) {
        this.code = code;
        Message = message;
        this.data = data;
    }
    public static BaseInterface success( String Message, Object data){
        return new BaseInterface(200,Message,data);
    }
    public static BaseInterface success(int code, String Message, Object data){
        return new BaseInterface(code,Message,data);
    }
    public static BaseInterface error(int code, String Message, Object data){
        return new BaseInterface(code,Message,data);
    }

}
