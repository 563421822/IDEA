package controller;

import lombok.SneakyThrows;
import service.IDeleteService;
import service.impl.DeleteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        IDeleteService service = new DeleteServiceImpl();
        int result = service.delete(name);
        if (result > 0) {
            resp.getWriter().write("删除成功,3秒后跳转到联系人列表");
            resp.setHeader("refresh", "3;ContactsServlet?curr=1");
        }
    }
}
