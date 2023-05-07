package com.example.demo.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo.mapper.TOrderMapper;
import com.example.demo.model.ResBean;
import com.example.demo.model.ResEnum;
import com.example.demo.model.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-06-27
 */

@Controller
public class TOrderController {

    @Autowired
    private TOrderMapper tOrderMapper;

    //是一个insert操作 单条数据
    @PostMapping("order/good")
    @ResponseBody
    public ResBean order(TOrder tOrder){

        int i = tOrderMapper.insert(tOrder);
        if (i==0){
            return ResBean.error(ResEnum.PAY_ERROR);
        }
            return ResBean.success(ResEnum.PAY_Success);
    }

}

