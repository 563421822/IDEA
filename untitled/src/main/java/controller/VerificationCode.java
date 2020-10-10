package controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/VerificationCode")
public class VerificationCode extends HttpServlet {
    final int width = 120;
    final int height = 40;
    final int codeCount = 4;
    final int lineCount = 10;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidateCode validateCode = new ValidateCode(width, height, codeCount, lineCount);
        String code = validateCode.getCode();
        System.out.println("生成的验证码:" + code);
//        存在session方便后台判断
        req.getSession().setAttribute("code", code);
//        将验证码图片通过流的方式输送给客户端展示
        validateCode.write(resp.getOutputStream());

    }
}
