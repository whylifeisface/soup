package com.example.demo.mapper;

import com.example.demo.model.TGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-06-24
 */
@Mapper
public interface TGoodsMapper extends BaseMapper<TGoods> {

    List<TGoods> GetMessage();
    TGoods GetMessageByid(Long id);
}
