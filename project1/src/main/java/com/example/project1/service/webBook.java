package com.example.project1.service;


import com.example.project1.util.batisTest;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@RequestMapping("/api")
public class webBook {
    //分页查询 /book/t-a-s-y
    @GetMapping("/book/{type}")
    public void  select01(HttpRequest req){
        SqlSession session = batisTest.getsession();
        URI uri = req.getURI();
        String s = uri.toString();//bug提醒::如果uri不是a-b-c这种必定错
        String[] type = s.split("-");
        List<book> books = session.selectList("com.example.project1.mapper.bookMapper",type);
        //ModelAndView mav = new ModelAndView();

    }
    @PostMapping("/book/b")
    public String abc(HttpServletRequest req) throws IOException {
        MultipartHttpServletRequest mulReq = (MultipartHttpServletRequest) req;
        MultipartFile MultipartFile = mulReq.getFile("myfile");//input name属性值把
        //assert file != null;
        if (MultipartFile != null) {
            String fileName = MultipartFile.getOriginalFilename();
            MultipartFile.transferTo(new File("D:/project1"+fileName));
        }
        return "result";
    }
}
