package com.example.demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 实现servlet
 * 1创建java类
 * 2创建Servlet的规范，继承HttpServlet
 * 3重写service方法,指定访问路径
 */
/*
HttpServletResponse对象
    getWriter()     字符输出流
    getOutPoutStream    字节输出流 输出任意类型

    response只有一个
    两种流不可同时使用
 */
    /*
    响应乱码
        在流前面设置
        修改服务器的编码格式 iso8859-1 resp.setCharsetEncoding("UTF-8")
        修改客服端的编码格式  resp.setHead("content-type","text/html;charset=UTF-8")
        同时设置resp.setContentType("text/html;charset=UTF-8")
     */
    /*
    重定向
        特点
        resp.sendRedirect
            1.存在两次请求
            2.服务端指导，客服端行为
            3.地址会变
            req resp 不共享
     */
    /*
    请求转发和重定向
    请求转发 地址不会变 重定向会改变
    请求转发有一次请求   有两次
    请求转发req的域共享  不共享
    请求转发是服务端  客服端
    请求转发对host有要求  可以跨域
     */
/*
    Cookeie
    设置
            Cookie cookie = new Cookie("a", "b");

                resp.addCookie(cookie);
    获取
      Cookie[] cookies = req.getCookies();
    到期时间 setMaxAge(int time)负数不存储
    cookie default值是-1表示浏览器关闭就消失
    注意 cookie存中文用URLEncoder.encode 获取.decode
 */

@WebServlet("/ser01")
public class Hello extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//      String Url = req.getRequestURL()+"";

//      String Uri = req.getRequestURI();
//      String Method = req.getMethod();
//      String prototol = req.getProtocol();
//      String webapp = req.getContextPath();
//        System.out.println(webapp);
        PrintWriter write = resp.getWriter();
        write.write("i will win unless i want lose ");
//        Cookie cookie = new Cookie("a", "b");
//        resp.addCookie(cookie);


        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String Name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("name" + Name + "value" + value);
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
/*
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("hello world");
        resp.getWriter().write("hello servlet");
    }
 */

}
