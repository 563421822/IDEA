package controller;

import lombok.SneakyThrows;
import service.IAddService;
import service.impl.AddServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAddService service = new AddServiceImpl();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        int result = service.add(name, password, phone, address);
        if (result > 0) {
            resp.getWriter().write("添加成功,3秒后返回页面");
            resp.setHeader("refresh", "3;ContactsServlet?curr=1");
        }
    }
}
