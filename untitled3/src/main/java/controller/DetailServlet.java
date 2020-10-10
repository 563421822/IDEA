package controller;

import entity.TrainInfoEntity;
import lombok.SneakyThrows;
import service.ITrainDetailService;
import service.impl.TrainDetailServiceImpl;

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
        String trainNo = req.getParameter("trainNo");
        ITrainDetailService service = new TrainDetailServiceImpl();
        ArrayList<TrainInfoEntity> list = service.showDetail(trainNo);
        for (TrainInfoEntity t : list) {
            System.out.println(t);
        }

        req.setAttribute("detail", list);
        req.getRequestDispatcher("detail.jsp").forward(req, resp);
    }
}
