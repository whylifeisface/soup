package com.example.demo.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class bookClassification {
    private Long id;
    private String bookName;
    private int bookSize;
}
