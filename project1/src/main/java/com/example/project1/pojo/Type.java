package com.example.project1.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("bookClassification")
public class Type {
    private Long id;
    private String author;
    private String book_name;
    private String Classification;
    private String detail_Classification;
    private String photo;
    private String bookStatus;
    private int bookSize;
   // private
}
