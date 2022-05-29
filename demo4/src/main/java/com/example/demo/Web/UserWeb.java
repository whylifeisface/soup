package com.example.demo.Web;

import com.example.demo.Service.UserService;
import com.example.demo.pojo.User;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Controller

@RequestMapping("/soup")
public class UserWeb {
    @Autowired
    UserService userService;
    @Autowired
    User user;

    @GetMapping("/5")
    public String sa(){
        return "upload";
    }

    @PostMapping("/upload")
    public String Uploader(User user) throws IOException {
        for(MultipartFile ff:user.getFile()){
            String filename = ff.getOriginalFilename();
            if (filename != null){
//                ((CommonsMultipartFile)ff).getFileItem().getName().replaceAll("“","").replaceAll("”","");
                byte[] bytes = filename.getBytes();
                ff.transferTo(new File("F:\\java\\download" + filename) );
                user.setUsername("15");
                user.setFilepath(filename);
            }
            userService.updatePhotoService(user);

            return "success";

        }
        return "failure";
    }



//    视图解析器
    @GetMapping("/login")
    public String LoginPage( Model model){
        return "login";
    }
    @PostMapping("/api/login")
    public String login(String username,String password){

        String pass = userService.Return(username);
        if (!Objects.equals(pass, password)){

            return "redirect:login";
        }
        return "forward:success";
    }

}
