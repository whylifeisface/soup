package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.model.Bean;
import com.example.demo.model.TGoods;
import com.example.demo.mapper.TGoodsMapper;
import com.example.demo.service.TGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-06-24
 */
@Service
@Slf4j
public class TGoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements TGoodsService {

    @Autowired
    private   TGoodsMapper tGoodsMapper;
//    @Autowired
//    private DateFormUtil dateFormUtil;

    @Override
    public List<TGoods> GetMessage() {
        return tGoodsMapper.GetMessage();
    }




    @Override
    public TGoods GetMessageByid(Long id) {
        TGoods tGoods = tGoodsMapper.GetMessageByid(id);
        Date date = new Date(System.currentTimeMillis());

        Date SSndTime = tGoods.getStartDate();
        Date endTime = tGoods.getEndTime();

        log.info(String.valueOf(date.after(endTime)));
        if (date.before(SSndTime)){
            tGoods.setState(0);
        }
        else if (date.after(endTime)){
            tGoods.setState(2);
        }else {
            tGoods.setState(1);
        }
        log.info(String.valueOf(tGoods.getState()));
        return tGoods;
    }

    public int updateSock(TGoods tGoods) {
        Integer sockCount = tGoods.getSockCount()-1;
        tGoods.setSockCount(sockCount);
        return tGoodsMapper.updateById(tGoods);
    }

    @Override
    public List<TGoods> getStaticAll() {
        return tGoodsMapper.selectList(new QueryWrapper<TGoods>());
    }


}
