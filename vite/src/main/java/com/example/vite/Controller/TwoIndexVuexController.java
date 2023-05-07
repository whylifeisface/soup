package com.example.vite.Controller;


import com.example.vite.Bean.bean;
import com.example.vite.generator.domain.TwoIndexVuex;
import com.example.vite.generator.service.impl.TwoIndexVuexServiceImpl;
import com.example.vite.utils.getTitleUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("TwoIndexVuexController")
public class TwoIndexVuexController {
    @Resource
    private TwoIndexVuexServiceImpl twoIndexVuexServiceimp;

    @PostMapping("insert")
    public bean<Boolean> insert(@RequestBody TwoIndexVuex twoIndexVuex) throws IOException {
        System.out.println(twoIndexVuex.getWeb_url());
        if (!StringUtils.hasLength(twoIndexVuex.getWeb_url())) return new bean<>(400," ",Boolean.FALSE);
        if (!StringUtils.hasLength(twoIndexVuex.getTitle())){
            String s = getTitleUtils.MethodsGet(twoIndexVuex.getWeb_url());
            twoIndexVuex.setTitle(s);
        }
        boolean save = twoIndexVuexServiceimp.save(twoIndexVuex);
        if (!save) {
            return new bean<>(400," ",Boolean.FALSE);
        }
        return new bean<>(200,"",Boolean.TRUE);
    }
    @GetMapping("list")
    public bean<List<TwoIndexVuex>> list(){
        List<TwoIndexVuex> list = twoIndexVuexServiceimp.list();
        if (list == null) {
            return new bean<>(400," ",null);

        }
        return new bean<>(200," ",list);

    }


}
