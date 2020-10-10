package service;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecondServlet extends HttpServlet {
    public SecondServlet() {
        System.out.println("SecondServlet.SecondServlet构造方法");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("SecondServlet.init方法");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service方法");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SecondServlet.doPost");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SecondServlet.doGet");
    }

    @Override
    public void destroy() {

        System.out.println("SecondServlet.destroy方法");
    }
}
