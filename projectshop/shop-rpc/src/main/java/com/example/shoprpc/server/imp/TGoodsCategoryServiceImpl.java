package com.example.shoprpc.server.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shoprpc.mapper.TGoodsCategoryMapper;
import com.example.shoprpc.pojo.TGoodsCategory;
import com.example.shoprpc.server.ITGoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-07-04
 */
@Service
public class TGoodsCategoryServiceImpl implements ITGoodsCategoryService {

    @Autowired
    private TGoodsCategoryMapper tGoodsCategoryMapper;
    @Override
    public List<TGoodsCategory> List() {
     return  tGoodsCategoryMapper.selectList(new QueryWrapper<TGoodsCategory>());
    }

    @Override
    public int EditById(TGoodsCategory tGoodsCategory) {
        return tGoodsCategoryMapper.updateById(tGoodsCategory);

    }


    @Override
    public int DelById(Long id) {
        return tGoodsCategoryMapper.deleteById(id);
    }

    @Override
    public IPage<TGoodsCategory> PageGoods(Page<TGoodsCategory> page) {
      return  tGoodsCategoryMapper.selectPage(page,new QueryWrapper<>());
    }

    @Override
    public Long GetCount() {
       return tGoodsCategoryMapper.selectCount(new QueryWrapper<>());

    }

    @Override
    public List<TGoodsCategory> CateGet() {
     return  tGoodsCategoryMapper.CateMapp();

    }

    @Override
    public List<TGoodsCategory> NameMobile() {
      return  tGoodsCategoryMapper.selectNameMobile();


    }


}
