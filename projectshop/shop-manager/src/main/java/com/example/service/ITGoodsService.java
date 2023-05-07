package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.TGoods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-07-06
 */
public interface ITGoodsService extends IService<TGoods> {

    List<TGoods> GetAll();

    IPage<TGoods> GetPage(Page<TGoods> objectPage);


    IPage<TGoods> SortGood(Page<TGoods> objectPage, TGoods tGoods);


    TGoods KeySort(TGoods tGoods);

    Long GetPageTotal();
}
