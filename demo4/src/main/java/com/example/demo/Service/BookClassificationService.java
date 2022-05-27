package com.example.demo.Service;

import com.example.demo.mapper.bookClassificationMapper;
import com.example.demo.pojo.bookClassification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookClassificationService {
    @Autowired
    bookClassificationMapper bookclassmapper;


    public bookClassification SelectCById(int id){

       return bookclassmapper.selectById(id);
    }
}
