package controller;

import entity.Entity;
import lombok.SneakyThrows;
import service.IEditService;
import service.impl.EditServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Object adminSuccess = req.getSession().getAttribute("adminSuccess");
        Object normalSuccess = req.getSession().getAttribute("normalSuccess");
        if (adminSuccess != null) {
            //            管理员做编辑普通用户操作
            String name = req.getParameter("name");
            IEditService service = new EditServiceImpl();
            ArrayList<Entity> list = service.edit(name);
            if (list != null) {
                req.setAttribute("queryByName", list);
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }
        } else if (normalSuccess != null) {
//普通用户做修改信息操作
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
