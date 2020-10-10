package controller;

import entity.ContactsEntity;
import lombok.SneakyThrows;
import service.IDetailService;
import service.impl.DetailSeviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        IDetailService service = new DetailSeviceImpl();
        ArrayList<ContactsEntity> list = service.detail(name);
        if (list != null) {
            req.setAttribute("edit", "编辑");
            req.setAttribute("list", list);
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        }
    }
}
