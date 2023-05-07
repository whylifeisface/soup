package com.example.shoprpc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.example.entity.TGoodsCategory;
import com.example.shoprpc.pojo.TGoodsCategory;
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
