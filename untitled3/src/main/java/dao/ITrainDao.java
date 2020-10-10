package dao;

import entity.TrainInfoEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ITrainDao {
    ArrayList<TrainInfoEntity> queryAll() throws SQLException;

    ArrayList<TrainInfoEntity> queryDetail(String trainNo) throws SQLException;
}
