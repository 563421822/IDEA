package controller;

import entity.Entity;
import lombok.SneakyThrows;
import service.IManageService;
import service.impl.ManageServiceImpl;
import utils.Page;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//       接收前端传过来的当前页参数
        int curr = Integer.parseInt(request.getParameter("curr"));

        Page page = new Page();
//        将当前页存在对象中
        page.setCurrentPage(curr);

        IManageService service = new ManageServiceImpl();
//        将对象传到service层处理
        ArrayList<Entity> list = service.manage(page);
        if (list != null) {
            request.setAttribute("list", list);
            request.setAttribute("page", page);
            request.getRequestDispatcher("manage.jsp").forward(request, response);
        }
    }
}
