package com.example.demo1;

//import javax.servlet.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/soup")
public class servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest res,
                           HttpServletResponse resp) throws IOException,
            ServletException {
        System.out.println("hello soup");
        resp.getWriter().write("hello soup");
    }
};
// @Override
//protected void doPost(HttpServletRequest res, HttpServletResponse resp)throws IOException, ServletException {};
