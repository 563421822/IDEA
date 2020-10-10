package service.impl;

import dao.ITrainDao;
import dao.impl.TrainDaoImpl;
import entity.TrainInfoEntity;
import service.IListTrainService;

import java.sql.SQLException;
import java.util.ArrayList;

public class ListTrainServiceImpl implements IListTrainService {
    //    展示所有列车的信息
    @Override
    public ArrayList<TrainInfoEntity> listTrain() throws SQLException {
        ITrainDao dao = new TrainDaoImpl();
        return dao.queryAll();
    }
}
