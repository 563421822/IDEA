package controller;

import service.ILoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    @lombok.SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        ILoginService service = new LoginServiceImpl();
        int result = service.login(name, password);
        if (result > 0) {
            req.getSession().setAttribute("success", "已登录");
            resp.getWriter().write("登录成功,3秒后跳转到欢迎页面");
            resp.setHeader("refresh", "3;welcome.xhtml");
        } else {
            resp.getWriter().write("登录失败");
            resp.setHeader("refresh", "3;index.jsp");
        }
    }
}
