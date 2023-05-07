package com.example.project1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.project1.pojo.Type;
import org.apache.ibatis.annotations.Mapper;



import java.util.List;
@Mapper
public interface bookMapper extends BaseMapper<Type> {
     public Type select01(List<Type> list);
}
