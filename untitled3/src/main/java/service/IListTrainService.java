package service;

import entity.TrainInfoEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IListTrainService {
    ArrayList<TrainInfoEntity> listTrain() throws SQLException;
}
