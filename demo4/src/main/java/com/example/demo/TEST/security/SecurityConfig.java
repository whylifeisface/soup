package com.example.demo.TEST.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserServiceImp userServiceImp;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(userServiceImp).passwordEncoder(pw());
//        auth.inMemoryAuthentication()
//                .withUser("lucy").password(encode).roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginProcessingUrl("/api/login")
                .loginPage("/login")
                .successForwardUrl("/success")
                .failureForwardUrl("/failure")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .authorizeRequests()
                .antMatchers("/api/login","/login.html","/login","/1").permitAll()
                .antMatchers("/upload").permitAll()
                .anyRequest().authenticated();
        http.csrf().disable();

    }

    @Bean
    public BCryptPasswordEncoder pw(){

    return new BCryptPasswordEncoder();


}

}
