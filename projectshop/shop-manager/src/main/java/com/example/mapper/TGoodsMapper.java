package com.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.TGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-07-06
 */
@Mapper
public interface TGoodsMapper extends BaseMapper<TGoods> {

    List<TGoods> select();

    IPage<TGoods> select(Page<TGoods> objectPage);

    IPage<TGoods> selectSort(Page<TGoods> page, TGoods tGoods);

    TGoods KeySort(TGoods tGoods);
}
