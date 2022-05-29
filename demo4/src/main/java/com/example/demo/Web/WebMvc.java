package com.example.demo.Web;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebMvc {

    @RequestMapping("/1")
    public String webmvc(){
        System.out.println("====================");
        return "success";
    }
    @RequestMapping("/3")
    public String fail(){
        return "failure";
    }

}
