package com.example.controller;


import com.example.entity.ResBean;
import com.example.entity.TGoodsType;
import com.example.serviceImpl.TGoodsTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-07-06
 */
@RestController
@RequestMapping("/example/tGoodsType")
public class TGoodsTypeController {


    @Autowired
    private TGoodsTypeServiceImpl tGoodsTypeService;
    @GetMapping("init/type")
    public ResBean InitType(){
        return new ResBean("200","success",tGoodsTypeService.InitType());
    }
}

