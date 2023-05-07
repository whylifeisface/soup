package com.example.mapper;

import com.example.entity.TBrand;
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
public interface ITBrandMapper extends BaseMapper<TBrand> {

    List<TBrand> select();
}
