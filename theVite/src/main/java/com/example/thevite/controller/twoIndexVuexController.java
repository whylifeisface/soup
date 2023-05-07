package com.example.thevite.controller;

import com.example.thevite.Base.bean;
import com.example.thevite.model.TwoIndexVuex;
import com.example.thevite.service.impl.TwoIndexVuexServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("twoIndexVuexController")
public class twoIndexVuexController {
    @Resource
    private TwoIndexVuexServiceImpl twoIndexVuexService;
    @PostMapping("insert")
    public bean<Boolean> insertOne(@RequestBody TwoIndexVuex twoIndexVuex){
        boolean save = twoIndexVuexService.save(twoIndexVuex);
        if (!save) {
            return new bean<>(400,"",null);
        }
        return new bean<>(200,"",save);
    }
    @GetMapping("list")
    public bean<List<TwoIndexVuex>> list(){
        List<TwoIndexVuex> twoIndexVuexes = twoIndexVuexService.list();
        if (twoIndexVuexes == null) {

            return new bean<>(400,"",null);

        }
        return new bean<>(200,"",twoIndexVuexes);
    }
}
