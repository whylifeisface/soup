package com.example.demo.service;

import com.example.demo.model.TSeckillOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-06-27
 */
public interface TSeckillOrderService extends IService<TSeckillOrder> {

    Long GenerateOderId(Long userid);



    TSeckillOrder GenerateSecOrder(HttpServletRequest req, TSeckillOrder tSeckillOrder);

    int insertOne(TSeckillOrder tSeckillOrder);

    List<TSeckillOrder> getUser();
}
