package com.example.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.TGoods;
import com.example.entity.TGoodsType;
import com.example.mapper.TGoodsMapper;
import com.example.mapper.TGoodsTypeMapper;
import com.example.service.ITGoodsTypeService;
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
public class TGoodsTypeServiceImpl extends ServiceImpl<TGoodsTypeMapper, TGoodsType> implements ITGoodsTypeService {

    @Autowired
    private TGoodsTypeMapper tGoodsTypeMapper;
    @Override
    public List<TGoodsType> InitType() {
        return tGoodsTypeMapper.selectList(new QueryWrapper<>());


    }
}
