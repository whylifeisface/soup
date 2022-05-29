package com.example.demo.Web;

import com.example.demo.Service.UserService;
import com.example.demo.TEST.security.UserServiceImp;
import com.example.demo.pojo.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.Objects;

@Controller
public class UserWeb {
    @Autowired
    UserService userService;



//    视图解析器
    @GetMapping("/login")
    public String LoginPage( Model model){
        return "login";
    }
    @PostMapping("/api/login")
    public String login(String username,String password){

        String pass = userService.Return(username);
        if (!Objects.equals(pass, password)){

            return "forward:failure";
        }
        return "redirect:success";
    }

}
