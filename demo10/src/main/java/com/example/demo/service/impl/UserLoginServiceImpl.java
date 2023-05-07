package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Utils.CookieUtil;
import com.example.demo.Utils.Md5Utils;
import com.example.demo.model.ResBean;
import com.example.demo.model.ResEnum;
import com.example.demo.model.TUserDO;
import com.example.demo.model.UserLogin;
import com.example.demo.mapper.UserLoginMapper;
import com.example.demo.service.UserLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.index.PathBasedRedisIndexDefinition;
import org.springframework.stereotype.Service;

import javax.naming.ldap.PagedResultsControl;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-06-22
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements UserLoginService {



    @Autowired
    private TUserServiceImpl tUserService;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public ResBean loginUser(UserLogin userlogin, HttpServletResponse response) {

        if (userlogin.getUsername() == " " ||userlogin.getPassword() == " "){
            return ResBean.error(ResEnum.UserNotFind);
        }
        String passWord = userlogin.getPassword();
        String md5Second = Md5Utils.Md5Second(passWord);
        //UserLogin userLogin = userLoginMapper.selectOne(new QueryWrapper<UserLogin>().eq("username", userlogin.getUsername()));
//        存了redis但没完全存
        TUserDO tUser = tUserService.selectByPhone(userlogin.getUsername());
        //tUser = null
        redisTemplate.opsForValue().set("user"+tUser.getId(), tUser);

        if (!tUser.getPassword().toString().equals(md5Second)) {

            Cookie cookie = new Cookie("user", tUser.getId() + "");
            cookie.setPath("/");
            response.addCookie(cookie);

            return ResBean.success(ResEnum.LOGIN_SUCCESS);
        }
        return ResBean.error(ResEnum.UserNotFind);
    }

    @Override
    public TUserDO loadUerByCookie(HttpServletRequest request) {
        String id = CookieUtil.getFromCookie(request, "user");
        return tUserService.getUserFromCookie(id,request);
    }


}
