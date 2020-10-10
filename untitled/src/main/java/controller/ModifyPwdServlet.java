package controller;

import entity.Entity;
import lombok.SneakyThrows;
import service.IModifyPwdService;
import service.impl.ModifyPwdServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 修改密码的servlet
 */
@WebServlet("/ModifyPwdServlet")

public class ModifyPwdServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=utf-8");
//        原密码
        String origin = req.getParameter("origin");
        System.out.println(origin);
//        新密码
        String newPassword = req.getParameter("newPwd");
//        通过session获取实体类对象
        Entity adminSuccess = (Entity) req.getSession().getAttribute("adminSuccess");
        Entity normalSuccess = (Entity) req.getSession().getAttribute("normalSuccess");

        IModifyPwdService service = new ModifyPwdServiceImpl();
        int result = 0;
//        管理员已登录
        if (adminSuccess != null) {
            if (origin.equals(adminSuccess.getPassword())) {
                result = service.modifyPwd(newPassword, adminSuccess.getUsername(), adminSuccess.getPassword());
            }
//            普通用户已登录
        } else if (normalSuccess != null) {
            result = service.modifyPwd(newPassword, normalSuccess.getUsername(), normalSuccess.getPassword());
        }

        if (result > 0) {
            resp.getWriter().write("修改密码成功");
            resp.setHeader("refresh", "3;index.jsp");
        } else {
            resp.getWriter().write("修改失败!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }
}
