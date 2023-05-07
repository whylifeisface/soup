package com.example.demo.Utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.PublicKey;

public class Md5Utils {

    public static String md5(String password ){
       return DigestUtils.md5Hex(password);
    }
    private static final String salt = "123456";


    public static String Md5One(String password){
        return   md5(salt.charAt(1) + password + salt.charAt(5));
    }

    public static String Md5Second(String md5String){
        System.out.println(salt.charAt(1));
        return   md5(salt.charAt(1) + md5String + salt.charAt(5));
    }


}
