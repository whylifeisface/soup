package com.example.demo.server;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.pojo.ResBean;
import com.example.demo.pojo.admin;
import com.example.demo.utils.jjwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.HashMap;

@Service
public class IAdminServerImp implements IAdminServer{
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private jjwtUtil jjwtUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    public admin getAdminByusername(String username) {

      return  adminMapper.selectOne(new QueryWrapper<admin>()
              .eq("username",username).eq("enabled",true));
    }

    @Override
    public ResBean login(HttpRequest req, String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails==null || !passwordEncoder.matches(userDetails.getPassword(),password)){
            return ResBean.error("错误");
        }
        if (!userDetails.isEnabled()){
            return ResBean.error("账号被禁用");
        }

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        String token = jjwtUtil.generateToken(userDetails);
        HashMap<String , String > tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);

        return  ResBean.success("进入",tokenMap);
    }
}
