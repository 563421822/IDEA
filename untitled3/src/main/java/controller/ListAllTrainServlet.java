package controller;

import entity.TrainInfoEntity;
import lombok.SneakyThrows;
import service.IListTrainService;
import service.impl.ListTrainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ListAllTrainServlet")
public class ListAllTrainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IListTrainService service = new ListTrainServiceImpl();
        ArrayList<TrainInfoEntity> list = service.listTrain();
        for (TrainInfoEntity t : list) {
            System.out.println(t);
        }
//        集合中存的是对象,将集合带到下一个页面
        req.setAttribute("info", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
