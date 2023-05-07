package com.example.service;

import com.example.entity.TGoodsType;
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
public interface ITGoodsTypeService extends IService<TGoodsType> {

    List<TGoodsType> InitType();
}
