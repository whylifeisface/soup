package com.example.demo.controller;
import com.example.demo.pojo.AdminLoginParam;
import com.example.demo.pojo.ResBean;
import com.example.demo.server.IAdminServerImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@Api(tags = "loginController")
public class loginController {
    @Autowired
    private IAdminServerImp iAdminServerimp;

    @PostMapping("/login/sa")
    public ResBean Login(AdminLoginParam adminLoginParam, HttpRequest req){
        return iAdminServerimp.login(req,adminLoginParam.getUsername(),adminLoginParam.getPassword());

    }
    @ApiOperation(value = "用户登录")


    @PostMapping("/loginOut")
    public ResBean loginOut(){
        return ResBean.success("成功");
    }

}
