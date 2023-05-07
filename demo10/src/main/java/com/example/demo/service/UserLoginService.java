package com.example.demo.service;

import com.example.demo.model.ResBean;
import com.example.demo.model.UserLogin;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-06-22
 */
public interface UserLoginService extends IService<UserLogin> {

    ResBean loginUser(UserLogin userlogin, HttpServletResponse response);

    Object loadUerByCookie(HttpServletRequest request);
}
