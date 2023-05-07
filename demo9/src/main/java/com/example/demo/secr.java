package com.example.demo;
//

import com.example.demo.pojo.admin;
import com.example.demo.server.IAdminServer;
import com.example.demo.server.IAdminServerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class secr extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestEndpoints restEndpoints;
    @Autowired
    private RestAccessHandler restAccessHandler;
    @Autowired
    private IAdminServerImp iAdminServerImp;


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(
                 "/login",
                 "/doc.html","/css/**","/js/**",
                "/favicon.ico","index.html",
                        "/webjars/**","/swagger-resources/**",
                        "/v2/api-docs/**","/captcha"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/login","/logout")
                .permitAll()
                .anyRequest().permitAll()

//                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .addFilterBefore(filter(), UsernamePasswordAuthenticationFilter.class);

            //自定义未登录和结果返回
        http.exceptionHandling().accessDeniedHandler(restAccessHandler)
                .authenticationEntryPoint(restEndpoints);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtFilter filter(){
      return  new JwtFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return username -> {
            admin admin = iAdminServerImp.getAdminByusername(username);
            if (null!=admin) {
                return admin;
            }
            return null;
        };
    }


}