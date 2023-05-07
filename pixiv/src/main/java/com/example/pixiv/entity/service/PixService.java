package com.example.pixiv.entity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pixiv.entity.PixEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【pix】的数据库操作Service
* @createDate 2022-09-14 12:58:44
*/
public interface PixService extends IService<PixEntity> {
    IPage<PixEntity> getAll(Page<PixEntity> page);
}
