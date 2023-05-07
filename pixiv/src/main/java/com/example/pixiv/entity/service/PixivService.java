package com.example.pixiv.entity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pixiv.entity.PixivEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【pixiv】的数据库操作Service
* @createDate 2022-09-14 14:31:39
*/
public interface PixivService extends IService<PixivEntity> {
        IPage<PixivEntity> page(Page<PixivEntity> page);

    List<PixivEntity> getAll();

    int Post(PixivEntity pixiv);
}
