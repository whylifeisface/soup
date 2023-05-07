package com.example.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.TBrand;
import com.example.mapper.ITBrandMapper;
import com.example.service.ITBrandService;
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
public class TBrandServiceImpl extends ServiceImpl<ITBrandMapper, TBrand> implements ITBrandService {

    @Autowired
    private ITBrandMapper itBrandMapper;
    @Override
    public List<TBrand> getBrand() {
      return itBrandMapper.select();

    }
}
