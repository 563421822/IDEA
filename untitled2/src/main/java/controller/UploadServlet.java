package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/Upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath = req.getServletContext().getRealPath("/WEB-INF/upload");
        System.out.println("路径:" + realPath);
        Part p = req.getPart("file1");
        System.out.println("响应的内容类型:" + p.getContentType());
        System.out.println("获得头部信息:" + p.getHeader("content"));
        System.out.println("获得头部名称:" + p.getHeaderNames());
        System.out.println("获得表单input元素name属性名:" + p.getName());
        System.out.println("获得文件大小:" + p.getSize());
        //System.out.println("获得提交的文件名:" + p.getSubmittedFileName());
        p.write(realPath/* + "/" + FileName*/);
        System.out.println("上传成功");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
