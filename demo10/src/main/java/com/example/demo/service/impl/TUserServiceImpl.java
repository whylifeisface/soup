package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Utils.CookieUtil;
import com.example.demo.Utils.Md5Utils;
import com.example.demo.mapper.TUserMapper;
import com.example.demo.model.TUserDO;
import com.example.demo.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-06-18
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUserDO> implements TUserService {

    @Autowired
    private TUserMapper tUserMapper;


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public TUserDO getUserFromCookie(String ticker, HttpServletRequest request) {

        return (TUserDO)redisTemplate.opsForValue().get("user" + ticker);
    }


    @Override
    public int login(String username, String password, HttpServletResponse res) {
        if (!StringUtils.isBlank(username) && !StringUtils.isBlank(password)){
            TUserDO tu = tUserMapper.selectOne(new QueryWrapper<TUserDO>().eq("id", username));
            String pass = tu.getPassword();
            String p = Md5Utils.Md5Second(pass);
            if (p.equals(password)){
                String ticker = UUID.randomUUID().toString();
//                CookieUtil.SetCookie(res, ticker);
//                redisTemplate.opsForValue().set("user"+ticker,tu);
                return  1;
            }
        }
        return 0;
    }

    @Override
    public TUserDO selectByPhone(String username) {
       return tUserMapper.selectOne(new QueryWrapper<TUserDO>().eq("nickname",username));
    }


}
