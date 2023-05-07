package com.example.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.ResBean;
import com.example.demo.model.TUserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-06-18
 */
@Component
@Mapper
public interface TUserService extends IService<TUserDO> {

   TUserDO  getUserFromCookie(String ticker, HttpServletRequest request);





    int login(String username, String password, HttpServletResponse res);

    TUserDO selectByPhone(String username);
}
