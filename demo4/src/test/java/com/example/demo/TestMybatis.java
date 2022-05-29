package com.example.demo;

import com.example.demo.Service.BookClassificationService;
import com.example.demo.Service.UserService;
import com.example.demo.pojo.bookClassification;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@MapperScan("com.example.demo.Mapper")
public class TestMybatis {
    @Autowired
    BookClassificationService bookClassificationService;
    @Autowired
    UserService userService;

    @Test
    public void test01(){
        int id = 1;
        bookClassification s = bookClassificationService.SelectCById(id);
        System.out.println(s);
    }
    @Test
    public void sa(){
        String aReturn = userService.Return("zhangsan");
        System.out.println(aReturn);
    }
}
