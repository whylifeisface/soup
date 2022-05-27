package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.bookClassification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface bookClassificationMapper  extends BaseMapper<bookClassification> {
    public bookClassification selectBlog(int id);
}

