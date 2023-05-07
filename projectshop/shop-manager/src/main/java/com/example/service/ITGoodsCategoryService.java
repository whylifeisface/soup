package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.TGoodsCategory;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-07-04
 */
public interface ITGoodsCategoryService extends IService<TGoodsCategory> {

    List<TGoodsCategory> List();

    int EditById(TGoodsCategory tGoodsCategory);



    int DelById(Long id);

    IPage<TGoodsCategory> PageGoods(Page<TGoodsCategory> page);

    Long GetCount();

    List<TGoodsCategory> CateGet();

    List<TGoodsCategory> NameMobile();
}
