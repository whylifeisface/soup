package com.example.mybatisplusboot;

import com.example.mybatisplusboot.mapper.UseMapper;
import com.example.mybatisplusboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestPlus {
    @Autowired
    private UseMapper useMapper;

    @Test
    public void testSelect(){
        useMapper.selectList()
    }


}
