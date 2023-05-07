package com.example.demo.ErrotHander;

import com.example.demo.model.ResBean;
import com.example.demo.model.ResEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.BindException;

@ControllerAdvice
public class Error {

    @ExceptionHandler(Exception.class)
    public ResBean ExceptH(Exception e){
        if (e instanceof BindException){
            return  ResBean.error(ResEnum.ERROR);
        }
        return null;
    }


}
