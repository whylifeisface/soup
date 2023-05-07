package com.example.thevite.Base;

public class bean<T> {
    private int code;
    private String message;
    private T data;

    public bean(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

//    public static bean success(String message, T data){
//        return new bean<>(200,message,data);
//    }
//    public static bean error(String message, T data){
//        return new bean<>(400,message,data);
//    }
}
