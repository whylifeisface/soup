package com.example.pixiv.entity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pixiv.entity.PixivEntity;
import com.example.pixiv.entity.service.PixivService;
import com.example.pixiv.entity.mapper.PixivMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【pixiv】的数据库操作Service实现
* @createDate 2022-09-14 14:31:39
*/
@Service
public class PixivServiceImpl extends ServiceImpl<PixivMapper, PixivEntity>
    implements PixivService{
    @Autowired
    private PixivMapper pixivMapper;
    @Override
    public IPage<PixivEntity> page(Page<PixivEntity> page) {
        return pixivMapper.selectPage(page,new QueryWrapper<>());
    }

    @Override
    public List<PixivEntity> getAll() {
        return pixivMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public int Post(PixivEntity pixiv) {
        return pixivMapper.insert(pixiv);
    }
}




