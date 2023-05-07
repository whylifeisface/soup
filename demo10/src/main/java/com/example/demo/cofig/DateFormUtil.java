package com.example.demo.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormUtil {
    // 定义格式
    private String str = "yyyy-MM-dd HH:mm:ss";

    /**
     * 格式转换
     * @param date
     * @return
     */

    public String DateFormat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        String df = sdf.format(date);
        return df;
    }

    /**
     * 以特定字符串返回当前时间
     * @return
     */

    public String CurDateFormt(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        String df = sdf.format(date);
        return df;
    }

}
