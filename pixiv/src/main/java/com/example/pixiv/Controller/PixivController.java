package com.example.pixiv.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pixiv.entity.PixivEntity;
import com.example.pixiv.entity.service.impl.PixivServiceImpl;
import com.example.pixiv.model.Base.BaseInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("PixivController")
public class PixivController {

    @Autowired
    private PixivServiceImpl pixivService;

    @GetMapping("Page")
    public BaseInterface Page(@RequestParam("num") int num,@RequestParam("size") int size){
        IPage<PixivEntity> page = pixivService.page(new Page<PixivEntity>(num, size));
//        List<PixivEntity> records = page.getRecords();
        if (page == null) {
         return    BaseInterface.error(400,"error",null);
        }
        return BaseInterface.success("success",page);
    }
    @GetMapping("all")
    public BaseInterface GetAll(){
        List<PixivEntity> all = pixivService.getAll();
        if (all == null) {
            return    BaseInterface.error(400,"error",null);
        }
        return BaseInterface.success("success",all);
    }
    @PostMapping("post")
    public BaseInterface Post(@RequestBody PixivEntity pixiv){
        if (pixiv == null){
            log.info("RequestBody 不能为空");
        return BaseInterface.error(400,"RequestBody 不能为空",null);
        }
       int i =  pixivService.Post(pixiv);
        if (i == 0) {
            log.info("插入失败");

            return BaseInterface.error(400,"插入失败  ",null);
        }
        log.info("Post success");

        return BaseInterface.success("success  ",null);

    }

}
