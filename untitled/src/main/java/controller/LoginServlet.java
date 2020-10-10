package controller;

import entity.Entity;
import lombok.SneakyThrows;
import service.ILoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Entity entity = new Entity();

        entity.setUsername(req.getParameter("username"));
        entity.setPassword(req.getParameter("password"));
        String role = req.getParameter("role");
        String verified = req.getParameter("verified");
        String remember = req.getParameter("remember");
        String code = (String) req.getSession().getAttribute("code");
        System.out.println(code);

        if (verified.equalsIgnoreCase(code)) {
//            验证码输入正确
            ILoginService service = new LoginServiceImpl();
//        调用service层
            int result = service.login(entity.getUsername(), entity.getPassword(), role);


            if (result > 0) {

//                如果勾选了记住我
                if ("on".equals(remember)) {
                    Cookie cookie1 = new Cookie("username", URLEncoder.encode(entity.getUsername(), StandardCharsets.UTF_8));
                    Cookie cookie2 = new Cookie("password", URLEncoder.encode(entity.getPassword(), StandardCharsets.UTF_8));
//添加用户名密码cookies
                    resp.addCookie(cookie1);
                    resp.addCookie(cookie2);
//设置cookies有效期
                    cookie1.setMaxAge(60);
                    cookie2.setMaxAge(60);
                }

                if ("admin".equals(role)) {
                    req.getSession().setAttribute("adminSuccess", entity);
                } else if ("normal".equals(role)) {
                    req.getSession().setAttribute("normalSuccess", entity);
                }

                resp.getWriter().write("登录成功,3秒后跳转到首页" + req.getSession());
                //                    跳转到首页
                resp.setHeader("refresh", "3;index.jsp");

            } else {
//                如果结果小于等于0,登录失败
                req.setAttribute("failed", "用户名或密码错误");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
//            如果验证码输入错误
            resp.getWriter().write("验证码错误!");
            resp.setHeader("refresh", "3;login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doPost(req, resp);
    }
}
