package com.example.demo.server;

import com.example.demo.pojo.ResBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;

public interface IAdminServer {
    ResBean login(HttpRequest req, String username, String password);
}
