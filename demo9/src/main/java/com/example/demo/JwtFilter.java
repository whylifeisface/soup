package com.example.demo;

import com.example.demo.pojo.AdminLoginParam;
import com.example.demo.pojo.admin;
import com.example.demo.utils.jjwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import springfox.documentation.spi.service.contexts.SecurityContext;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class JwtFilter  extends OncePerRequestFilter {

    @Autowired
    private com.example.demo.utils.jjwtUtil jjwtUtil;
    @Autowired
    private admin admin;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String tokenHeader = request.getHeader("tokenHeader");
        if (tokenHeader!=null && tokenHeader.startsWith(tokenHead) ){

            String jwt = tokenHeader.substring("Bearar".length() + 7);
            String username = jjwtUtil.getUserNameFormToken(jwt);

            if(null!=username &&null==SecurityContextHolder.getContext().getAuthentication())
                //登录
            {
                UserDetails user = userDetailsService.loadUserByUsername(username);
                //验证是否有效 重新设置用户对象
                if (jjwtUtil.validateToken(tokenHead,user)){
                    UsernamePasswordAuthenticationToken AuthenticationToken =
                            new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    AuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(AuthenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }


}
