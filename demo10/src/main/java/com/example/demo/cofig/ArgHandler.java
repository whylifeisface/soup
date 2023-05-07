package com.example.demo.cofig;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.Utils.CookieUtil;
import com.example.demo.model.ResBean;
import com.example.demo.model.ResEnum;
import com.example.demo.model.TUserDO;
import com.example.demo.model.UserLogin;
import com.example.demo.service.TUserService;
import com.example.demo.service.impl.TUserServiceImpl;
import com.example.demo.service.impl.UserLoginServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Objects;


public class ArgHandler implements HandlerMethodArgumentResolver {

    @Autowired
    private UserLoginServiceImpl userLoginService;


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();

        //暂时别这样 如果参数里面有TUserDO那么就要经过过滤器
        //从COOKIE里面拿到手机号 用手机号去redis查找用户
        return clazz == TUserDO.class;
    }

    @Override
    public Object resolveArgument(@NotNull MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);

//        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);

            return userLoginService.loadUerByCookie(request);

    }
}
