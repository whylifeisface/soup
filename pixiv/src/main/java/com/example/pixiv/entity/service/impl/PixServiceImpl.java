package com.example.pixiv.entity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pixiv.entity.PixEntity;
import com.example.pixiv.entity.service.PixService;
import com.example.pixiv.entity.mapper.PixMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【pix】的数据库操作Service实现
* @createDate 2022-09-14 12:58:44
*/
@Service
public class PixServiceImpl extends ServiceImpl<PixMapper, PixEntity>
    implements PixService{
    @Autowired
    private PixMapper pixMapper;

    @Override
    public IPage<PixEntity> getAll(Page<PixEntity> page) {

        return  pixMapper.selectPage(page,new QueryWrapper<>());
    }
}




