package com.example.demo.TEST.security;

import com.example.demo.Service.UserService;
import com.example.demo.pojo.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImp implements UserDetailsService {


    @Autowired
    UserService userService;


    @Override
    public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("开始执行");
        com.example.demo.pojo.User user  = userService.Return(username);
        if (user.getUsername()!=null){
            throw  new UsernameNotFoundException("用户名密码错误");
        }
        BCryptPasswordEncoder pw = new BCryptPasswordEncoder();
        String pd = pw.encode(user.getPassword());

        return new User(username, pd, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_lower"));

    }
}
