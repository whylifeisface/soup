package com.example.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.TGoods;
import com.example.mapper.TGoodsMapper;
import com.example.service.ITGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-07-06
 */
@Service
public class TGoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements ITGoodsService {

    @Autowired
    private TGoodsMapper tGoodsMapper;
    @Override
    public List<TGoods> GetAll() {

        return tGoodsMapper.select();


    }

    @Override
    public IPage<TGoods> GetPage(Page<TGoods> objectPage) {

      return tGoodsMapper.select(objectPage);
    }

    @Override
    public IPage<TGoods> SortGood(Page<TGoods> objectPage, TGoods tGoods) {
       return tGoodsMapper.selectSort(objectPage,tGoods);
    }

    @Override
    public TGoods KeySort(TGoods tGoods) {
       return tGoodsMapper.KeySort(tGoods);


    }

    @Override
    public Long GetPageTotal() {
       return tGoodsMapper.selectCount(new QueryWrapper<>());

    }


}
