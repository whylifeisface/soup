package com.example.demo.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo.Except;
import com.example.demo.Utils.CookieUtil;
import com.example.demo.Utils.JsonUtil;
import com.example.demo.mapper.TSeckillOrderMapper;
import com.example.demo.model.*;
import com.example.demo.service.impl.RabbitSend;
import com.example.demo.service.impl.TGoodsServiceImpl;
import com.example.demo.service.impl.TSeckillOrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-06-27
 */
@RestController
@Slf4j
public class TSeckillOrderController {

    @Autowired
    private TSeckillOrderServiceImpl tSeckillOrderService;

    @Autowired
    private RedisTemplate<String ,Object> redisTemplate;

    @Autowired
    private TGoodsServiceImpl tGoodsService;

    @Autowired
    private RabbitSend rabbitSend;



    @PostMapping("/sec/good")
    public ResBean secOrder(
        TSeckillOrder tSeckillOrder, HttpServletRequest req, Model model)  {

        TGoods tGoods = tGoodsService.GetMessageByid(tSeckillOrder.getId());


        //超卖
        if (tGoods.getSockCount() <= 0 ){
            return ResBean.error(ResEnum.SELL_TOOMUCH);
        }
        TSeckillOrder order =tSeckillOrderService.GenerateSecOrder(req,tSeckillOrder);
        //重复秒杀
        List<TSeckillOrder> users = tSeckillOrderService.getUser();
//
        for (TSeckillOrder user : users){

            if (Objects.equals(user.getUserId(), tSeckillOrder.getId())){
                return ResBean.error(ResEnum.CANNOT_SEC_SECOND);
            }

        }
        //是否是秒杀时间
        if (tGoods.getState() != 1 || order.getUserNotFind()==1 ){

            return ResBean.error(ResEnum.TIME_ISNOTNOW);
        }
        //是否成功支付
        int i = tSeckillOrderService.insertOne(tSeckillOrder);

        if (i==0){
            return ResBean.error(ResEnum.PAY_ERROR);
        }
        //是否减库存失败
        //redis预减库存 等价与什么呢 超卖和//重复秒杀  现在不好做 redis的值要是类似与列表的 查询到的tGoods写入
//        redisTemplate.opsForValue().set("secgood"+tSeckillOrder.getGoodId(),tGoods.getSockCount());
//        Object sock = redisTemplate.opsForValue().get("secgood" + tSeckillOrder.getGoodId());
        // //超卖
//        SeckillMessage message = new SeckillMessage(,tSeckillOrder.getId());
//        rabbitSend.MessageSend(JsonUtil.toJson(message));
//        if (sock != null){
//            if (Integer.parseInt(sock.toString()) > 0){
//                redisTemplate.opsForValue().decrement("secgood" + tSeckillOrder.getGoodId());
//            }
//
//        }
        int in = tGoodsService.updateSock(tGoods);
        if (in == 0){
            return ResBean.error(ResEnum.UPDATE_T_ORDER_ERROR);
        }
        return ResBean.success(ResEnum.PAY_Success);
    }
}

