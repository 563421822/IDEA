package controller;

import lombok.SneakyThrows;
import service.IEditService;
import service.impl.EditServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        通过名字修改信息
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        IEditService service = new EditServiceImpl();
        int result = service.edit(name, phone, address);
        if (result > 0) {
            resp.getWriter().write("修改成功,3秒后跳转到联系人列表");
            resp.setHeader("refresh", "3;ContactsServlet?curr=1");
        }
    }
}
