package com.hp.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "UserSelectServlet",urlPatterns = "/UserSelectServlet")
public class UserSelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req ,HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req ,resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8"); // 注意 , 别写错

        //2. 接收 前端过来的 3个参数
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        //
        UserService userService = new UserService();
        Map map = userService.PageBeanUtil(Integer.parseInt(page),Integer.parseInt(limit));
        String s = JSONObject.toJSONString(map);
        PrintWriter writer = resp.getWriter();
        writer.print(s);
        writer.close();
    }
}
