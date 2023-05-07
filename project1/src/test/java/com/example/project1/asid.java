package com.example.project1;

import com.example.project1.service.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class asid {
    @Autowired
    Type type;
    @Test
    public void test(){

        System.out.println(type.TypeC("玄幻"));


    }


}
