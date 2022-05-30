package com.example.demo.Web;

import com.example.demo.Service.UserService;
import com.example.demo.TEST.security.UserServiceImp;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
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
    public String Uploader(@RequestPart MultipartFile[] file,
                           @RequestParam String username
                           ) throws IOException {

        if(null==username && null==file){
            return "failure";
        }
        for(MultipartFile ff:file){
            String filename = ff.getOriginalFilename();
            if (filename != null){
                ff.transferTo(new File("F:\\java\\download" + filename) );
                user.setPhotoPath(filename);
            }
        }
        user.setUsername("152");
        user.setNewName(username);
        userService.updatePhotoService(user);

        return "success";
    }



//    视图解析器
    @GetMapping("/login")
    public String LoginPage(){

        return "login";
    }


    @PostMapping("/api/login")
    public String login(String username,
       HttpServletRequest req,
       HttpServletResponse res
                        ) {

        return "success";

    }

}
