package dao.impl;

import dao.ITrainDao;
import entity.TrainInfoEntity;
import utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrainDaoImpl implements ITrainDao {
    final ArrayList<TrainInfoEntity> LIST = new ArrayList<>();

    @Override
    public ArrayList<TrainInfoEntity> queryAll() throws SQLException {

        String sql = "SELECT * FROM train_info";
        ResultSet query = DBUtils.query(sql);
        while (query.next()) {
            TrainInfoEntity entity = new TrainInfoEntity();
            entity.setTrainNo(query.getString("train_no"));
            entity.setStartStation(query.getString("start_station"));
            entity.setArrivalStation(query.getString("arrival_station"));
            entity.setStartTime(query.getString("start_time"));
            entity.setArrivalTime(query.getString("arrival_time"));
            entity.setType(query.getString("type"));
            entity.setRuntime(query.getString("runtime"));
            entity.setMile(query.getDouble("mile"));
            LIST.add(entity);
        }
        return LIST;
    }

    @Override
    public ArrayList<TrainInfoEntity> queryDetail(String trainNo) throws SQLException {
        String sql = "SELECT * FROM train_info WHERE train_no =?";
        ResultSet query = DBUtils.query(sql, trainNo);
        if (query.next()) {
            TrainInfoEntity entity = new TrainInfoEntity();
            entity.setTrainNo(query.getString("train_no"));
            entity.setStartStation(query.getString("start_station"));
            entity.setArrivalStation(query.getString("arrival_station"));
            entity.setStartTime(query.getString("start_time"));
            entity.setArrivalTime(query.getString("arrival_time"));
            entity.setType(query.getString("type"));
            entity.setRuntime(query.getString("runtime"));
            entity.setMile(query.getDouble("mile"));
            LIST.add(entity);
        }
        return LIST;
    }
}
