package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data

@Slf4j
public class ResBean {
    private ResEnum resEnum;

    private int code;
    private String message;

    public ResBean(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResBean success(ResEnum responseEnum)  {
            log.info(responseEnum.getCode().toString());
            return new ResBean(responseEnum.getCode(),responseEnum.getMessage());
    }

    public static ResBean error(ResEnum resEnum) {
        return new ResBean(resEnum.getCode(),resEnum.getMessage());
    }
}
