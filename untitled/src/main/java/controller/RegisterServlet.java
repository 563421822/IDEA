package controller;

import entity.Entity;
import lombok.SneakyThrows;
import service.IRegisterService;
import service.impl.RegisterServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        设置请求编码,以"UTF-8"方法传出数据
        req.setCharacterEncoding("UTF-8");
        Entity user = new Entity();

        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setGender(req.getParameter("gender"));
        user.setBirthday(req.getParameter("birthday"));
        user.setHobby(Arrays.toString(req.getParameterValues("hobby")));
        user.setCity(req.getParameter("city"));
        System.out.println(user);

        IRegisterService service = new RegisterServiceImpl();
        int result;


        result = service.register(user.getUsername(), user.getPassword(), user.getGender(), user.getBirthday(), user.getHobby(), user.getCity());


        if (result > 0) {
            resp.getWriter().write("注册成功! success!");
        } else {
            resp.getWriter().write("注册失败! failed!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }
}
