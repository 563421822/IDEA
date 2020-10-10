package com.wyl.zy.dao;

import com.wyl.zy.entity.GameEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IGameDao {
    int updateByAccount(String account, double sum) throws SQLException;

    ArrayList<GameEntity> queryAllField() throws SQLException;

    double queryPrice(int chosenId) throws SQLException;

    boolean updateAllAcount(double price, int num) throws SQLException;

    double queryOwn() throws SQLException;

}
