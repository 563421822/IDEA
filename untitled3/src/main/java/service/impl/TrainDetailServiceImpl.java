package service.impl;

import dao.ITrainDao;
import dao.impl.TrainDaoImpl;
import entity.TrainInfoEntity;
import service.ITrainDetailService;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrainDetailServiceImpl implements ITrainDetailService {
    @Override
    public ArrayList<TrainInfoEntity> showDetail(String trainNo) throws SQLException {
        ITrainDao dao = new TrainDaoImpl();
        return dao.queryDetail(trainNo);
    }
}
