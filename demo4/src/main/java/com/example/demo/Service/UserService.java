package com.example.demo.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User Return(String username){
       return userMapper.ReturnPassword(username);
    }
    public int updatePhotoService(User user){
        return userMapper.updatePhoto(user);
    }
}
