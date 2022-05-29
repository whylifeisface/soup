package com.example.demo.TEST.security;

import com.example.demo.Service.UserService;
//import com.example.demo.pojo.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


public class UserServiceImp implements UserDetailsService {
    @Autowired
    BCryptPasswordEncoder pw;
    @Autowired
    UserService userService;


    @Override
    public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


            String password = userService.Return(username);

            String pd = pw.encode(password);

            return new User(username, pd, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_lower"));

    }
}
