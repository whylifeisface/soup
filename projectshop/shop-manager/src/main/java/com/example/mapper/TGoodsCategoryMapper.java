package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.TGoodsCategory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-07-04
 */
@Mapper
public interface TGoodsCategoryMapper extends BaseMapper<TGoodsCategory> {

    List<TGoodsCategory> CateMapp();

    List<TGoodsCategory> selectNameMobile();
}
