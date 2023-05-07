package com.example.demo.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Utils.Md5Utils;

import com.example.demo.mapper.UserLoginMapper;
import com.example.demo.model.ResBean;
import com.example.demo.model.ResEnum;
import com.example.demo.model.UserLogin;
import com.example.demo.service.TUserService;
import com.example.demo.service.UserLoginService;
import com.example.demo.service.impl.TUserServiceImpl;
import com.example.demo.service.impl.UserLoginServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@Controller
@Slf4j
public class Login {


    @Autowired
    private UserLoginServiceImpl userLoginService;
    @Autowired
    private UserLoginMapper userLoginMapper;



    @GetMapping("login")
    public String login(){
        return "login";
    }



    @Qualifier("TUserServiceImpl")
    @Autowired
    private TUserService tUserService;

    @GetMapping("success")
    public String success(){
        return "success";
    }



    /**
     * 登录

     */
    @PostMapping("/login/post")
    @ResponseBody
    public ResBean loginPost(Model model, UserLogin userlogin, HttpServletResponse response){
//        if (userlogin.getUsername()!= null |
//                Objects.equals(userlogin.getPassword(), " ")
//                ||userlogin.getUsername()!= null||
//                Objects.equals(userlogin.getPassword(), " ")){
//            log.info("用户名密码不能为空");
//            return new ResBean(ResEnum.UserNotFind);
//        }
        return userLoginService.loginUser(userlogin,response);


//        String name = userlogin.getUsername();
//            String pass = userlogin.getPassword().toString();
//
//            UserLogin DataFormDataBase = userLoginMapper.selectOne(new QueryWrapper<UserLogin>()
//                    .eq("username",name));
//
//
////        log.info(Md5Utils.Md5Second(pass));
//
//
//
//        System.out.println("111111");
//
//        log.info(userlogin.getPassword());
//
//        Cookie cookie = new Cookie("id", DataFormDataBase.getId().toString());
//        response.addCookie(cookie);
//
//        return new ResBean(ResEnum.LOGIN_SUCCESS);
    }

}
