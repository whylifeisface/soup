package com.example.demo.Utils;

import com.example.demo.model.TUserDO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class CookieUtil {

    public static String getFromCookie(HttpServletRequest request, String key){
        Cookie[] cookies = request.getCookies();
        for (int i = 0 ;i <= cookies.length;i++){
            if (cookies[i].getName().equalsIgnoreCase(key)){
                return cookies[i].getValue().toString();
            }
        }
        return null;
    }
    public static void SetCookie( HttpServletResponse res, String key,String value){
        Cookie cookie = new Cookie(key, value);
        res.addCookie(cookie);
    }


}
