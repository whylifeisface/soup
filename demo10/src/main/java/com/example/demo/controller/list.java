package com.example.demo.controller;


import com.example.demo.model.Bean;
import com.example.demo.model.TGoods;
import com.example.demo.model.UserLogin;
import com.example.demo.service.impl.TGoodsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Slf4j
public class list {

    @Autowired
    private TGoodsServiceImpl tGoodsServiceImpl;
    @Resource
    private ThymeleafViewResolver thymeleafViewResolver;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("goods/getlist")
    public String getGoods( Model model,
                           HttpServletRequest req, HttpServletResponse res){
//        if (userLogin == null){
//            return null;
//        }
        String o = (String) redisTemplate.opsForValue().get("/get/list");
//        if (!StringUtils.isEmpty(o)){
//            return o;
//        }
        List<TGoods> goodsList = tGoodsServiceImpl.GetMessage();

        model.addAttribute("goodList",goodsList);

        WebContext webContext = new WebContext(req, res,
                req.getServletContext(), req.getLocale(), model.asMap());
        String htmlPro = thymeleafViewResolver.getTemplateEngine().process("list.html", webContext);
        if (!StringUtils.isEmpty(htmlPro)){
            redisTemplate.opsForValue().set("/get/list",htmlPro);
            return htmlPro;
        }
        return null;
    }
    @RequestMapping("static/detail")
    @ResponseBody
    public TGoods StaticDetail( Long id){

        return tGoodsServiceImpl.GetMessageByid(id);
    }


    @RequestMapping("goodDetail/{id}")
    public String GetDetail(@PathVariable Long id, Model model){
        TGoods tGoods = tGoodsServiceImpl.GetMessageByid(id);

        model.addAttribute("tGoods",tGoods);

        log.info(tGoods.toString());
        return "detail";
    }
    @GetMapping("/static/list")
    @ResponseBody
    public Bean StaticList(){
        return new Bean("200",tGoodsServiceImpl.getStaticAll());
    }
}
