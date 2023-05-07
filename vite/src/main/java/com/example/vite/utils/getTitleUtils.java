package com.example.vite.utils;

import org.springframework.util.StringUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getTitleUtils {
   public static String MethodsGet(String urlString) throws IOException {
       String result = "";
       BufferedReader in=null;
       URL url = new URL(urlString);
       try {
           URLConnection urlConnection = url.openConnection();
           urlConnection.setRequestProperty("accept", "*/*");
           urlConnection.setRequestProperty("connection", "Keep-Alive");
           urlConnection.setRequestProperty("user-agent",
                   "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
           urlConnection.connect();
           in = new BufferedReader(new InputStreamReader(
                   urlConnection.getInputStream()
           ));
           String line;
           while ((line = in.readLine()) != null) {
               result = getTitleContent(line);
               if (StringUtils.hasLength(result)) {
                   break;
               }
           }
       }
       finally {
           try {
               if ( in != null) {
                   in.close();
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    return result;
   }
   public static String  getTitleContent(String content){
       System.out.println(content);
       Pattern compile = Pattern.compile("<title>(.*?)</title>");
       Matcher matcher = compile.matcher(content);
       boolean b = matcher.find();
       if (!b) {
           return "点击添加名称";
       }

       return matcher.group().substring(7,matcher.group().length()-8);
   }
}
