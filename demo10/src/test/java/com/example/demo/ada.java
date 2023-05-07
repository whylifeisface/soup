package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.example.demo.Utils.Md5Utils;
import com.example.demo.mapper.TGoodsMapper;
import com.example.demo.mapper.UserLoginMapper;
import com.example.demo.model.TGoods;
import com.example.demo.model.TUserDO;
import com.example.demo.model.UserLogin;
import com.example.demo.service.impl.TUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
public class ada {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Test
    public void tex(){
        String s = Md5Utils.md5("password");
        System.out.println(s);
    }

    @Test
    public void tex1(){
        String s = Md5Utils.Md5One("password");
        System.out.println(s);
    }
    @Test
    public void tex12(){
//        String s = Md5Utils.Md5One("password");
        String a = Md5Utils.Md5Second("5dfd6fa84028b52477733d148a99a9cb");
        System.out.println(a);
    }

//    5dfd6fa84028b52477733d148a99a9cb
//    99c4f2a288c4badce1f76281b23dc256
//    151abb01708e4d1930d06f6ad56140ad

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Test
    public void tex121(){
        String s = Md5Utils.Md5Second("5dfd6fa84028b52477733d148a99a9cb");
        UserLogin DataFormDataBase = userLoginMapper.selectOne(new QueryWrapper<UserLogin>()
                .eq("username","soup"));
        System.out.println(s);
        System.out.println(DataFormDataBase);
    }


    @Autowired
    private TGoodsMapper tGoodsMapper;
    @Test
    public void tex1213(){
        List<TGoods> tGoods = tGoodsMapper.GetMessage();
        System.out.println(tGoods);
    }
    @Test
    public void tex1213a(){
        Long a = 1L;
        TGoods tGoods = tGoodsMapper.GetMessageByid(a);
        System.out.println(tGoods);
    }
    @Autowired
    private TUserServiceImpl tUserService;

    @Test
    public void  setRedisTemplate(){
//
        TUserDO userLogin = tUserService.selectByPhone("15255315676");

        redisTemplate.opsForValue().set("user"+userLogin.getId(), userLogin);
    }


}
