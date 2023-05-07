package com.example.project1.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;
@Data
@TableName(value = "one")
public class book {
    private int totalPage;
    private int like;
    private String name;
    private Date lastUpdate;
    private String tags;
    private String author;


}
