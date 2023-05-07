package com.example.project1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.project1.pojo.Type;
import com.example.project1.pojo.book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface TypeMapper extends BaseMapper<Type> {
    //全属性的查找
    public Type selectClassification(String s);

}
