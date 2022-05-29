package com.example.demo.Service;

import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public String Return(String username){
       return userMapper.ReturnPassword(username);
    }
}
