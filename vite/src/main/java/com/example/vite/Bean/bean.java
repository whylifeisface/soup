package com.example.vite.Bean;


import java.io.Serializable;

public class bean<T> implements Serializable {
    private int code;

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

    private String message;
    private T data;

    public bean() {
    }

    public bean(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
