package com.example.pixiv.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pixiv.entity.PixEntity;
import com.example.pixiv.entity.service.impl.PixServiceImpl;
import com.example.pixiv.model.Base.BaseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("PixController")
public class PixController {
    @Autowired
    private PixServiceImpl pixService;
    @GetMapping("getAll")
    public BaseInterface getAll(@RequestParam("num")int num,@RequestParam("size")int size){

        IPage<PixEntity> all =
                pixService.getAll(new Page<>(num, size));
        if (all == null) {
            return BaseInterface.error(400,"success",null);
        }
        return BaseInterface.success("success",all);

    }

}
