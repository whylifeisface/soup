package com.example.pixiv.entity.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.pixiv.entity.PixEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【pix】的数据库操作Mapper
* @createDate 2022-09-14 12:58:44
* @Entity com.example.pixiv.entity.PixEntity
*/
@Mapper
public interface PixMapper extends BaseMapper<PixEntity> {

    IPage<PixEntity> getAll(IPage<?> page);
}




