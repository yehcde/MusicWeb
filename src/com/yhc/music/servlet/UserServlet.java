package com.yhc.music.servlet;


import com.yhc.music.bean.User;
import com.yhc.music.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 用户Servlet
 *
 * @author yehaocheng
 * @version 1.0
 */
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathName = request.getServletPath();
        if (Objects.equals("/userInfo.do", pathName)) {
            request.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(request, response);
        } else if (Objects.equals("/editUserPrompt.do", pathName)) {
            Long id = Long.valueOf(request.getParameter("id"));
            User user = userService.getUserById(id);
            if (null != user) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/views/biz/edit_user.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(request, response);
            }
        } else if (Objects.equals("/editUser.do", pathName)) {
            Long id = Long.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            User user = new User();
            user.setId(id);
            user.setUsername(name);
            user.setPassword(password);
            user.setPhone(phone);
            boolean result = userService.updateUser(user);
            if (result) {
                request.getSession().setAttribute("user", user);
                request.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/biz/404.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
        }
    }


}
