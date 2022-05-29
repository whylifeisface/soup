package com.example.demo.TEST.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginProcessingUrl("/soup/api/login")
                .loginPage("/soup/login.html")
                .successForwardUrl("/soup/success")
                .failureForwardUrl("/soup/failure")
                .and()
                .authorizeRequests()
                .antMatchers("soup/api/login","/soup/login.html","/soup/login","/soup/1").permitAll()

                .and().csrf().disable()
                ;

    }

    @Bean
    public BCryptPasswordEncoder pw(){

    return new BCryptPasswordEncoder();


}

}
