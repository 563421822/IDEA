package service;

import entity.TrainInfoEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ITrainDetailService {
    ArrayList<TrainInfoEntity> showDetail(String trainNo) throws SQLException;
}
