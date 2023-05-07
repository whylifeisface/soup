package com.example.demo.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class collont {
    @GetMapping(value = "/logi?paramn", produces = {MediaType.IMAGE_JPEG_VALUE,"image/jpeg"})
    @ResponseBody
    public byte[] mase() throws IOException {

        ArrayList<String> list = new ArrayList<String>();
        list.add("F:\\java\\project\\demo9\\src\\main\\resources\\static\\1.jpg");
        list.add("F:\\java\\project\\demo9\\src\\main\\resources\\static\\2.jpg");
        Random random = new Random();
        int i = random.nextInt(2);
        String s = list.get(i);
        System.out.println(s);
        File file = new File(s);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        int read = inputStream.read(bytes, 0, inputStream.available());
        System.out.println(read);
        return bytes;
  }
}
