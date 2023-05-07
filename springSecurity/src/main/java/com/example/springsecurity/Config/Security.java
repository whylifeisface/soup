package com.example.springsecurity.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
            return httpSecurity
                    .formLogin()

                    .loginProcessingUrl("/in")
//                    .loginPage("/login.html")
                    .and().rememberMe()
//                    .rememberMeParameter("rememberMe")
                    .and()
                    .authorizeRequests()
//                    .antMatchers("/login.html").permitAll()

                    .anyRequest().authenticated().and()
                    .csrf().disable()
                    .authenticationManager(new AuthenticationManager() {
                        @Override
                        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                            return authentication;
                        }
                    })

                    .build();
    }




    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
