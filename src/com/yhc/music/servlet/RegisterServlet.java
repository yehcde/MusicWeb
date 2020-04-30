package com.yhc.music.servlet;

import com.yhc.music.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 注册Servlet
 *
 * @author yehaocheng
 * @version 1.0
 */

public class RegisterServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathName = request.getServletPath();
        if (Objects.equals("/register.do", pathName)) {
            request.getRequestDispatcher("/WEB-INF/views/biz/register.jsp").forward(request, response);
        } else if (Objects.equals("/registerUser.do", pathName)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean result = userService.register(username,password);
            if (result) {
                request.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
        }
    }
}

