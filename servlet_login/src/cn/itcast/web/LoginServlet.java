package cn.itcast.web;

import cn.itcast.entity.User;
import cn.itcast.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author xiaoming
 * @create 2018-10-09-22:09
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //调用业务逻辑
        UserService userService = new UserService();
        User user = userService.login(username,password);
        //分发转向
        //根据response对象获取字符打印流
        PrintWriter out = response.getWriter();

        if (user==null){
            out.write("login error");

        }else {
            out.write("login success");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
