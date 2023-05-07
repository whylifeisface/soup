package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.ResBean;
import com.example.entity.TGoodsCategory;
import com.example.service.UploadServerImp;
import com.example.serviceImpl.TGoodsCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-07-04
 */
@RestController
@RequestMapping("/example/tGoodsCategory")
public class TGoodsCategoryController {

    @Autowired
    private UploadServerImp uploadServerImp;
    @Autowired
    private TGoodsCategoryServiceImpl tGoodsCategoryService;

    @RequestMapping("get/count")
    public ResBean GetCount(){
       return new ResBean("200","success",tGoodsCategoryService.GetCount());
    }
//shop-manger/example/tGoodsCategory/get/page/1
    @RequestMapping("get/page/{num}")
    public ResBean PageGoods(@PathVariable("num") int num){
        Page<TGoodsCategory> Page = new Page<>(num ,10);
        return new ResBean("200","success",tGoodsCategoryService.PageGoods(Page).getRecords());
    }

    @RequestMapping("get/goods")
    public ResBean ListGoods(){
      return new ResBean("200","success",tGoodsCategoryService.List());
    }

    @PostMapping("edit")
    public ResBean EditTGood(@RequestPart("json")  TGoodsCategory tGoodsCategory,
                              @RequestPart("file")   MultipartFile multipartFile
    ) throws IOException {
        System.out.println(        tGoodsCategory           );
                String filename = multipartFile.getOriginalFilename();
        filename = System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));
        String result = uploadServerImp.upload(multipartFile.getInputStream(), filename);
        System.out.println(result);
        tGoodsCategory.setImage(result);
        int i = tGoodsCategoryService.EditById(tGoodsCategory);
        if ( 0 == i ){
            return new ResBean("403","修改失败",null);
        }
        return new ResBean("200","修改成功",null);
    }
    @GetMapping("del/{id}")
    public ResBean DelTGood(@PathVariable Long id){
       int i = tGoodsCategoryService.DelById(id);
        if ( 0 == i ){
            return new ResBean("403","删除失败",null);
        }
        return new ResBean("200","删除成功",null);
    }
    @GetMapping("cate/get")
    public ResBean CateGet(){
      return new ResBean("200","success",tGoodsCategoryService.CateGet());
    }
    @GetMapping("name/mobilename")
    public ResBean NameMobile(){
      return new ResBean("200","success",tGoodsCategoryService.NameMobile());


    }

}

