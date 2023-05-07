package com.example.demo.service;

import com.example.demo.model.TGoods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-06-24
 */
public interface TGoodsService extends IService<TGoods> {

    List<TGoods> GetMessage();

    TGoods GetMessageByid(Long id);

    int updateSock(TGoods tGoods);

    List<TGoods> getStaticAll();
}
