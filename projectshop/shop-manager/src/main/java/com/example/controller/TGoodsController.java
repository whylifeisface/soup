package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.ResBean;
import com.example.entity.TGoods;
import com.example.serviceImpl.TGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/example/tGoods")
public class TGoodsController {

    @Autowired
    private TGoodsServiceImpl tGoodsService;

    @GetMapping("get/pageTotal")
    public ResBean getpageTotal(){
       return new ResBean("200","success",tGoodsService.GetPageTotal());
    }

    @GetMapping("get/all")
    public ResBean GetAll(){
        return new ResBean("200","success",tGoodsService.GetAll());
    }

    @GetMapping("get/Page/{num}")
    public ResBean GetPage(@PathVariable("num") int num){
        Page<TGoods> objectPage = new Page<>(num,10);
        return new ResBean("200","success",tGoodsService.GetPage(objectPage).getRecords());
    }
    @PostMapping("sort/goods/{num}")
    public ResBean SortGood( @PathVariable("num") int num,TGoods tGoods){
        Page<TGoods> objectPage = new Page<>(num,10);
        return new ResBean("200","success",tGoodsService.SortGood(objectPage,tGoods));
    }
    @GetMapping("Key/Sort")
    public ResBean KeySort(TGoods tGoods){
        return new ResBean("200","success",tGoodsService.KeySort(tGoods));
    }

}

