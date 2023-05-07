package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Utils.CookieUtil;
import com.example.demo.model.TSeckillOrder;
import com.example.demo.mapper.TSeckillOrderMapper;
import com.example.demo.service.TSeckillOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-06-27
 */
@Service
@Slf4j
public class TSeckillOrderServiceImpl extends ServiceImpl<TSeckillOrderMapper, TSeckillOrder> implements TSeckillOrderService {

    @Autowired
    private TSeckillOrderMapper tSeckillOrderMapper;

    @Override
    public Long GenerateOderId(Long userid) {
        String str = "Herrscher of Reason "; //理之律者英文名
        Long valueOf = Long.valueOf(str.charAt(5));
        Long time = new Date().getTime();
        return userid+time+valueOf;
    }

    @Override
    public TSeckillOrder GenerateSecOrder(HttpServletRequest req, TSeckillOrder tSeckillOrder)  {

        String userid = CookieUtil.getFromCookie(req, "user");
        log.info(userid);
        if (userid != null){
            TSeckillOrderServiceImpl serverImp = new TSeckillOrderServiceImpl();

            Long oderId = serverImp.GenerateOderId(Long.valueOf(userid));
            tSeckillOrder.setUserId(Long.valueOf(userid));
            tSeckillOrder.setOrderId(oderId);
            tSeckillOrderMapper.insert(tSeckillOrder);
            return tSeckillOrder;
        }
        tSeckillOrder.setUserNotFind(1);
        return tSeckillOrder;
    }

    @Override
    public int insertOne(TSeckillOrder tSeckillOrder) {
        return tSeckillOrderMapper.insert(tSeckillOrder);
    }

    @Override
    public List<TSeckillOrder> getUser() {

    return tSeckillOrderMapper.selectList(new QueryWrapper<TSeckillOrder>());


    }
}
