package com.comm.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by shiweiwei on 2017/5/16.
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet{

    private String message;
    @Override
    public void init() throws ServletException {
        super.init();
        message = "Hello world, this message is from servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8"); //防止中文乱码
        PrintWriter out = resp.getWriter();
        String name =new String(req.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
//        String name = req.getParameter("name").getBytes("ISO8859-1").toString();
        String password = new String(req.getParameter("password").getBytes("ISO8859-1"),"UTF-8");
        if (name.equals("shiweiwei") && password.equals("123456")){
            message = "登陆成功";
        }else {
            message = "账号或密码不正确";
        }
        out.println("<h3>" + message + "</h3>");
    }
}
