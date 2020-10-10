package controller;

import entity.ContactsEntity;
import lombok.SneakyThrows;
import service.IContactsService;
import service.impl.ContactsServiceImpl;
import utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 显示所有联系人的Servlet
 */
@WebServlet("/ContactsServlet")
public class ContactsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IContactsService service = new ContactsServiceImpl();
//        获得传过来的页码
        int curr = Integer.parseInt(req.getParameter("curr"));
        Page page = new Page();
//        设置当前页起始记录数
        page.setCurrentPage(curr);
        ArrayList<ContactsEntity> list = service.show(page);
        if (list != null) {
            req.setAttribute("list", list);
            req.setAttribute("page", page);
            req.getRequestDispatcher("contacts.jsp").forward(req, resp);
        }
    }
}
