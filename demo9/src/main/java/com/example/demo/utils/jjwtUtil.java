package com.example.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class jjwtUtil {
    private static final String CLAIM_KEY_USERNAME="sub";
    private static final String CLAIM_KEY_CREATE="created";
    @Value("${jwt.secret}")
    private String  secret;
    @Value("${jwt.expiration}")
    private Long  expiration;

    public  String generateToken(UserDetails userDetail) {

        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetail.getUsername());
        claims.put(CLAIM_KEY_CREATE,new Date());
        return generateToken(claims);
    }
    public  String generateToken(Map<String,Object> cliams){
        return Jwts.builder()
                .setClaims(cliams)
                .setExpiration(generateExpiation())
                .signWith(SignatureAlgorithm.ES256,secret)
                .compact();
    }
    public Date generateExpiation(){
        return new Date(System.currentTimeMillis()+ expiration * 1000);
    }
//    获取username
    public String getUserNameFormToken(String token){
        String username = null;
        try {
            Claims claimFromToken = getClaimFromToken(token);
            username = claimFromToken.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    public Claims getClaimFromToken(String token) {
        Claims claims = null;
        try{
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  claims;
    }
//    检测jwt 过期 是否相同
    public boolean validateToken(String token, UserDetails userDetails){
        String userNameFormToken = getUserNameFormToken(token);
        return userNameFormToken.equals(userDetails.getUsername()) && ! isTokenExpiration(token);
    }
    public boolean isTokenExpiration(String token){
        Date date = getExpried(token);
        return date.before(new Date());
    }

    public Date getExpried(String token){
        Claims claim = getClaimFromToken(token);
         return claim.getExpiration();
    }
//    是否需要刷新jwt
    public boolean canRefresh(String token){
        return !isTokenExpiration(token);
    }
//    刷新实现
    public String refreshToken(String token){
        Claims claims = getClaimFromToken(token);
        claims.put(CLAIM_KEY_CREATE,new Date());
        return generateToken(claims);
    }
}
