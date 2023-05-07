package com.example.controller;


import com.example.entity.ResBean;
import com.example.entity.TBrand;
import com.example.serviceImpl.TBrandServiceImpl;
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
@RequestMapping("/example/tBrand")
public class TBrandController {
    @Autowired
    private TBrandServiceImpl tBrandService;

    @GetMapping("brand/get")
    public ResBean getBrand(){
       return new ResBean("200","success",tBrandService.getBrand());
    }
}

